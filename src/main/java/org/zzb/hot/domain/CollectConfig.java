package org.zzb.hot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.zzb.base.BaseEntity;


/**
 * 采集配置对象 collect_config
 *
 * @author zzb
 * @date 2023-12-12
 */
public class CollectConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采集配置id */
    private Long collectConfigId;

    /** 采集id */
    private Long collectId;

    /** 配置名 */
    private String configName;

    /** 采集参数 */
    private String collectParam;

    /** 版本号 */
    private String configVersion;

    /** 是否有效 */
    private String effect;

    /**
     * 单次记录最大条数
     */
    private int maxCount;

    /**
     * 是否记录原始数据
     */
    private String recordData;

    private String cron;

    /**
     * 请求设置，包含请求头以及请求方式，请求体等配置
     */
    private String requestConfig;

    /** 采集表达式 */
    private String collectExpression;

    /** 采集编码 */
    private String charset;

    /** 创建人 */
    private String creater;

    /** 更新人 */
    private String updater;

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getRecordData() {
        return recordData;
    }


    public void setRecordData(String recordData) {
        this.recordData = recordData;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public void setCollectConfigId(Long collectConfigId)
    {
        this.collectConfigId = collectConfigId;
    }

    public String getRequestConfig() {
        return requestConfig;
    }

    public void setRequestConfig(String requestConfig) {
        this.requestConfig = requestConfig;
    }

    public Long getCollectConfigId()
    {
        return collectConfigId;
    }
    public void setCollectId(Long collectId)
    {
        this.collectId = collectId;
    }

    public Long getCollectId()
    {
        return collectId;
    }
    public void setConfigName(String configName)
    {
        this.configName = configName;
    }

    public String getConfigName()
    {
        return configName;
    }
    public void setCollectParam(String collectParam)
    {
        this.collectParam = collectParam;
    }

    public String getCollectParam()
    {
        return collectParam;
    }
    public void setConfigVersion(String configVersion)
    {
        this.configVersion = configVersion;
    }

    public String getConfigVersion()
    {
        return configVersion;
    }
    public void setEffect(String effect)
    {
        this.effect = effect;
    }

    public String getEffect()
    {
        return effect;
    }
    public void setCollectExpression(String collectExpression)
    {
        this.collectExpression = collectExpression;
    }

    public String getCollectExpression()
    {
        return collectExpression;
    }
    public void setCharset(String charset)
    {
        this.charset = charset;
    }

    public String getCharset()
    {
        return charset;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("collectConfigId", getCollectConfigId())
            .append("collectId", getCollectId())
            .append("configName", getConfigName())
            .append("collectParam", getCollectParam())
            .append("configVersion", getConfigVersion())
            .append("effect", getEffect())
            .append("collectExpression", getCollectExpression())
            .append("charset", getCharset())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("creater", getCreater())
            .append("updater", getUpdater())
            .toString();
    }
}
