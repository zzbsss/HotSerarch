package org.zzb.hot.mapper;

import org.zzb.hot.domain.CollectConfig;

import java.util.List;

/**
 * 采集配置Mapper接口
 *
 * @author zzb
 * @date 2023-12-12
 */
public interface CollectConfigMapper
{
    /**
     * 查询采集配置
     *
     * @param collectConfigId 采集配置ID
     * @return 采集配置
     */
    public CollectConfig selectCollectConfigById(Long collectConfigId);

    /**
     * 查询采集配置列表
     *
     * @param collectConfig 采集配置
     * @return 采集配置集合
     */
    public List<CollectConfig> selectCollectConfigList(CollectConfig collectConfig);

    /**
     * 新增采集配置
     *
     * @param collectConfig 采集配置
     * @return 结果
     */
    public int insertCollectConfig(CollectConfig collectConfig);

    /**
     * 修改采集配置
     *
     * @param collectConfig 采集配置
     * @return 结果
     */
    public int updateCollectConfig(CollectConfig collectConfig);

    /**
     * 删除采集配置
     *
     * @param collectConfigId 采集配置ID
     * @return 结果
     */
    public int deleteCollectConfigById(Long collectConfigId);

    /**
     * 批量删除采集配置
     *
     * @param collectConfigIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCollectConfigByIds(Long[] collectConfigIds);
}
