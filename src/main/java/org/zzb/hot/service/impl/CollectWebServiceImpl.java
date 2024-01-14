package org.zzb.hot.service.impl;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzb.hot.domain.CollectWeb;
import org.zzb.hot.mapper.CollectWebMapper;
import org.zzb.hot.service.ICollectWebService;

import java.util.List;

/**
 * 采集主体Service业务层处理
 *
 * @author zzb
 * @date 2023-12-12
 */
@Service
public class CollectWebServiceImpl implements ICollectWebService
{
    @Autowired
    private CollectWebMapper collectWebMapper;

    /**
     * 查询采集主体
     *
     * @param collectId 采集主体ID
     * @return 采集主体
     */
    @Override
    public CollectWeb selectCollectWebById(Long collectId)
    {
        return collectWebMapper.selectCollectWebById(collectId);
    }

    /**
     * 查询采集主体列表
     *
     * @param collectWeb 采集主体
     * @return 采集主体
     */
    @Override
    public List<CollectWeb> selectCollectWebList(CollectWeb collectWeb)
    {
        return collectWebMapper.selectCollectWebList(collectWeb);
    }

    /**
     * 新增采集主体
     *
     * @param collectWeb 采集主体
     * @return 结果
     */
    @Override
    public int insertCollectWeb(CollectWeb collectWeb)
    {
        collectWeb.setCreateTime(DateUtil.date());
        return collectWebMapper.insertCollectWeb(collectWeb);
    }

    /**
     * 修改采集主体
     *
     * @param collectWeb 采集主体
     * @return 结果
     */
    @Override
    public int updateCollectWeb(CollectWeb collectWeb)
    {
        collectWeb.setUpdateTime(DateUtil.date());
        return collectWebMapper.updateCollectWeb(collectWeb);
    }

    /**
     * 批量删除采集主体
     *
     * @param collectIds 需要删除的采集主体ID
     * @return 结果
     */
    @Override
    public int deleteCollectWebByIds(Long[] collectIds)
    {
        return collectWebMapper.deleteCollectWebByIds(collectIds);
    }

    /**
     * 删除采集主体信息
     *
     * @param collectId 采集主体ID
     * @return 结果
     */
    @Override
    public int deleteCollectWebById(Long collectId)
    {
        return collectWebMapper.deleteCollectWebById(collectId);
    }
}
