package org.zzb.hot.model.zhihu;


import com.alibaba.fastjson.JSONObject;

public class Target {
    private JSONObject titleArea;
    private JSONObject excerptArea;
    private JSONObject imageArea;
    private JSONObject metricsArea;
    private JSONObject labelArea;
    private JSONObject link;

    public JSONObject getTitleArea() {
        return titleArea;
    }

    public void setTitleArea(JSONObject titleArea) {
        this.titleArea = titleArea;
    }

    public JSONObject getExcerptArea() {
        return excerptArea;
    }

    public void setExcerptArea(JSONObject excerptArea) {
        this.excerptArea = excerptArea;
    }

    public JSONObject getImageArea() {
        return imageArea;
    }

    public void setImageArea(JSONObject imageArea) {
        this.imageArea = imageArea;
    }

    public JSONObject getMetricsArea() {
        return metricsArea;
    }

    public void setMetricsArea(JSONObject metricsArea) {
        this.metricsArea = metricsArea;
    }

    public JSONObject getLabelArea() {
        return labelArea;
    }

    public void setLabelArea(JSONObject labelArea) {
        this.labelArea = labelArea;
    }

    public JSONObject getLink() {
        return link;
    }

    public void setLink(JSONObject link) {
        this.link = link;
    }
}
