package org.zzb.hot.service.impl;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzb.hot.domain.CollectConfig;
import org.zzb.hot.mapper.CollectConfigMapper;
import org.zzb.hot.service.ICollectConfigService;

import java.util.List;

/**
 * 采集配置Service业务层处理
 *
 * @author zzb
 * @date 2023-12-12
 */
@Service
public class CollectConfigServiceImpl implements ICollectConfigService
{
    @Autowired
    private CollectConfigMapper collectConfigMapper;

    /**
     * 查询采集配置
     *
     * @param collectConfigId 采集配置ID
     * @return 采集配置
     */
    @Override
    public CollectConfig selectCollectConfigById(Long collectConfigId)
    {
        return collectConfigMapper.selectCollectConfigById(collectConfigId);
    }

    /**
     * 查询采集配置列表
     *
     * @param collectConfig 采集配置
     * @return 采集配置
     */
    @Override
    public List<CollectConfig> selectCollectConfigList(CollectConfig collectConfig)
    {
        return collectConfigMapper.selectCollectConfigList(collectConfig);
    }

    /**
     * 新增采集配置
     *
     * @param collectConfig 采集配置
     * @return 结果
     */
    @Override
    public int insertCollectConfig(CollectConfig collectConfig)
    {
        collectConfig.setCreateTime(DateUtil.date());
        return collectConfigMapper.insertCollectConfig(collectConfig);
    }

    /**
     * 修改采集配置
     *
     * @param collectConfig 采集配置
     * @return 结果
     */
    @Override
    public int updateCollectConfig(CollectConfig collectConfig)
    {
        return collectConfigMapper.updateCollectConfig(collectConfig);
    }

    /**
     * 批量删除采集配置
     *
     * @param collectConfigIds 需要删除的采集配置ID
     * @return 结果
     */
    @Override
    public int deleteCollectConfigByIds(Long[] collectConfigIds)
    {
        return collectConfigMapper.deleteCollectConfigByIds(collectConfigIds);
    }

    /**
     * 删除采集配置信息
     *
     * @param collectConfigId 采集配置ID
     * @return 结果
     */
    @Override
    public int deleteCollectConfigById(Long collectConfigId)
    {
        return collectConfigMapper.deleteCollectConfigById(collectConfigId);
    }
}
