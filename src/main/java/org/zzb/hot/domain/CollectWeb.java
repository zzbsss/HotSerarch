package org.zzb.hot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.zzb.base.BaseEntity;


/**
 * 采集主体对象 collect_web
 *
 * @author zzb
 * @date 2023-12-12
 */
public class CollectWeb extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采集id */
    private Long collectId;

    /** 采集接口(模版) */
    private String collectEndpoint;

    /** 采集主题 */
    private String collectTitle;

    /** 采集类型 */
    private Integer collectType;

    private String collectCode;

    /** 是否有效 */
    private String effecct;

    /** 创建人 */
    private String creater;

    /** 更新人 */
    private String updater;

    /** 说明 */
    private String collectDesc;

    public void setCollectId(Long collectId)
    {
        this.collectId = collectId;
    }

    public Long getCollectId()
    {
        return collectId;
    }
    public void setCollectEndpoint(String collectEndpoint)
    {
        this.collectEndpoint = collectEndpoint;
    }

    public String getCollectEndpoint()
    {
        return collectEndpoint;
    }
    public void setCollectTitle(String collectTitle)
    {
        this.collectTitle = collectTitle;
    }

    public String getCollectTitle()
    {
        return collectTitle;
    }
    public void setCollectType(Integer collectType)
    {
        this.collectType = collectType;
    }

    public Integer getCollectType()
    {
        return collectType;
    }
    public void setEffecct(String effecct)
    {
        this.effecct = effecct;
    }

    public String getEffecct()
    {
        return effecct;
    }
    public void setCreater(String creater)
    {
        this.creater = creater;
    }

    public String getCreater()
    {
        return creater;
    }
    public void setUpdater(String updater)
    {
        this.updater = updater;
    }

    public String getUpdater()
    {
        return updater;
    }

    public String getCollectDesc() {
        return collectDesc;
    }

    public void setCollectDesc(String collectDesc) {
        this.collectDesc = collectDesc;
    }

    public String getCollectCode() {
        return collectCode;
    }

    public void setCollectCode(String collectCode) {
        this.collectCode = collectCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("collectId", getCollectId())
            .append("collectEndpoint", getCollectEndpoint())
            .append("collectTitle", getCollectTitle())
            .append("collectType", getCollectType())
            .append("effecct", getEffecct())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("creater", getCreater())
            .append("updater", getUpdater()).append("collectCode", getCollectCode())
            .append("desc", getCollectDesc())
            .toString();
    }
}
