package org.zzb.hot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.zzb.base.BaseEntity;

/**
 * 采集内容对象 collect_content
 *
 * @author zzb
 * @date 2023-12-12
 */
public class CollectContent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采集内容id */
    private Long collectContentId;

    /** 主题 */
    private String title;

    private String param;


    private String configDesc;

    private Long collectId;

    private Long configId;

    private String hotMetric;

    /** 路径 */
    private String url;

    /** 图片路径 */
    private String img;

    /** 排行 */
    private Integer hotOrder;

    /** 原始数据 */
    private String datastr;

    /** 创建人 */
    private String creater;



    public void setCollectContentId(Long collectContentId)
    {
        this.collectContentId = collectContentId;
    }

    public String getHotMetric() {
        return hotMetric;
    }

    public void setHotMetric(String hotMetric) {
        this.hotMetric = hotMetric;
    }

    public Long getCollectContentId()
    {
        return collectContentId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }

    public Integer getHotOrder() {
        return hotOrder;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Long getCollectId() {
        return collectId;
    }

    public void setCollectId(Long collectId) {
        this.collectId = collectId;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getConfigDesc() {
        return configDesc;
    }

    public void setConfigDesc(String configDesc) {
        this.configDesc = configDesc;
    }

    public void setHotOrder(Integer hotOrder) {
        this.hotOrder = hotOrder;
    }

    public String getDatastr() {
        return datastr;
    }

    public void setDatastr(String datastr) {
        this.datastr = datastr;
    }

    public void setCreater(String creater)
    {
        this.creater = creater;
    }

    public String getCreater()
    {
        return creater;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("collectContentId", getCollectContentId())
            .append("title", getTitle())
            .append("url", getUrl())
            .append("img", getImg())
            .append("hotOrder", getHotOrder())
            .append("datastr", getDatastr())
            .append("createTime", getCreateTime())
            .append("creater", getCreater())
            .toString();
    }
}
