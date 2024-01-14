package org.zzb.hot.service;

import org.zzb.hot.domain.CollectContent;

import java.util.List;
import java.util.Map;

/**
 * 采集内容Service接口
 *
 * @author zzb
 * @date 2023-12-12
 */
public interface ICollectContentService
{
    /**
     * 查询采集内容
     *
     * @param collectContentId 采集内容ID
     * @return 采集内容
     */
    public CollectContent selectCollectContentById(Long collectContentId);

    /**
     * 查询采集内容列表
     *
     * @param collectContent 采集内容
     * @return 采集内容集合
     */
    public List<CollectContent> selectCollectContentList(CollectContent collectContent);

    /**
     * 新增采集内容
     *
     * @param collectContent 采集内容
     * @return 结果
     */
    public int insertCollectContent(CollectContent collectContent);

    /**
     * 修改采集内容
     *
     * @param collectContent 采集内容
     * @return 结果
     */
    public int updateCollectContent(CollectContent collectContent);

    /**
     * 批量删除采集内容
     *
     * @param collectContentIds 需要删除的采集内容ID
     * @return 结果
     */
    public int deleteCollectContentByIds(Long[] collectContentIds);

    /**
     * 删除采集内容信息
     *
     * @param collectContentId 采集内容ID
     * @return 结果
     */
    public int deleteCollectContentById(Long collectContentId);

    Map<String, Object> queryRealTime();
}
