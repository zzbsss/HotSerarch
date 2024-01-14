package org.zzb.hot.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzb.hot.domain.CollectConfig;
import org.zzb.hot.domain.CollectContent;
import org.zzb.hot.domain.CollectWeb;
import org.zzb.hot.mapper.CollectContentMapper;
import org.zzb.hot.service.ICollectConfigService;
import org.zzb.hot.service.ICollectContentService;
import org.zzb.hot.service.ICollectWebService;
import org.zzb.hot.strategy.support.CollectScheduled;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 采集内容Service业务层处理
 *
 * @author zzb
 * @date 2023-12-12
 */
@Service
public class CollectContentServiceImpl implements ICollectContentService
{
    @Autowired
    private CollectContentMapper collectContentMapper;

    @Autowired
    private Map<String, CollectScheduled<?>> pageProcessorMap;


    @Autowired
    private ICollectConfigService collectConfigService;

    @Autowired
    private ICollectWebService collectWebService;

    /**
     * 查询采集内容
     *
     * @param collectContentId 采集内容ID
     * @return 采集内容
     */
    @Override
    public CollectContent selectCollectContentById(Long collectContentId)
    {
        return collectContentMapper.selectCollectContentById(collectContentId);
    }

    /**
     * 查询采集内容列表
     *
     * @param collectContent 采集内容
     * @return 采集内容
     */
    @Override
    public List<CollectContent> selectCollectContentList(CollectContent collectContent)
    {
        return collectContentMapper.selectCollectContentList(collectContent);
    }

    /**
     * 新增采集内容
     *
     * @param collectContent 采集内容
     * @return 结果
     */
    @Override
    public int insertCollectContent(CollectContent collectContent)
    {
        collectContent.setCreateTime(DateUtil.date());
        return collectContentMapper.insertCollectContent(collectContent);
    }

    /**
     * 修改采集内容
     *
     * @param collectContent 采集内容
     * @return 结果
     */
    @Override
    public int updateCollectContent(CollectContent collectContent)
    {
        return collectContentMapper.updateCollectContent(collectContent);
    }

    /**
     * 批量删除采集内容
     *
     * @param collectContentIds 需要删除的采集内容ID
     * @return 结果
     */
    @Override
    public int deleteCollectContentByIds(Long[] collectContentIds)
    {
        return collectContentMapper.deleteCollectContentByIds(collectContentIds);
    }

    /**
     * 删除采集内容信息
     *
     * @param collectContentId 采集内容ID
     * @return 结果
     */
    @Override
    public int deleteCollectContentById(Long collectContentId)
    {
        return collectContentMapper.deleteCollectContentById(collectContentId);
    }

    @Override
    public Map<String, Object> queryRealTime() {
        Map<String, Object> resultMap = new HashMap<>();
        // 读取数据库采集，初始化采集实现
        List<CollectWeb> collectWebs = collectWebService.selectCollectWebList(new CollectWeb());
        for (CollectWeb collectWeb : collectWebs) {
            CollectScheduled<?> collectScheduled = pageProcessorMap.get(collectWeb.getCollectCode());
            if (Objects.isNull(collectScheduled)) {
                continue;
            }
            CollectConfig collectConfig = new CollectConfig();
            collectConfig.setCollectId(collectWeb.getCollectId());
            List<CollectConfig> collectConfigs = collectConfigService.selectCollectConfigList(collectConfig);
            if (CollectionUtil.isEmpty(collectConfigs)) {
                continue;
            }
            for (CollectConfig config : collectConfigs) {
                resultMap.put(config.getConfigName() ,collectScheduled.collect(config, false));
            }
        }
        return resultMap;
    }
}
