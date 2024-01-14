package org.zzb.hot.mapper;

import org.zzb.hot.domain.CollectWeb;

import java.util.List;

/**
 * 采集主体Mapper接口
 *
 * @author zzb
 * @date 2023-12-12
 */
public interface CollectWebMapper
{
    /**
     * 查询采集主体
     *
     * @param collectId 采集主体ID
     * @return 采集主体
     */
    public CollectWeb selectCollectWebById(Long collectId);

    /**
     * 查询采集主体列表
     *
     * @param collectWeb 采集主体
     * @return 采集主体集合
     */
    public List<CollectWeb> selectCollectWebList(CollectWeb collectWeb);

    /**
     * 新增采集主体
     *
     * @param collectWeb 采集主体
     * @return 结果
     */
    public int insertCollectWeb(CollectWeb collectWeb);

    /**
     * 修改采集主体
     *
     * @param collectWeb 采集主体
     * @return 结果
     */
    public int updateCollectWeb(CollectWeb collectWeb);

    /**
     * 删除采集主体
     *
     * @param collectId 采集主体ID
     * @return 结果
     */
    public int deleteCollectWebById(Long collectId);

    /**
     * 批量删除采集主体
     *
     * @param collectIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCollectWebByIds(Long[] collectIds);
}
