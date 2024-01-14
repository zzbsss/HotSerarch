package org.zzb.hot.model.baidu;

import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
public class BaiduHotModel implements Serializable {

    private String appUrl;
    private String desc;
    private String hotChange;
    private String hotScore;
    private String hotTag;
    private String hotTagImg;
    private String img;
    private String index;
    private String indexUrl;
    private String query;
    private String rawUrl;
    private List<String> show;
    private String url;
    private String word;

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHotChange() {
        return hotChange;
    }

    public void setHotChange(String hotChange) {
        this.hotChange = hotChange;
    }

    public String getHotScore() {
        return hotScore;
    }

    public void setHotScore(String hotScore) {
        this.hotScore = hotScore;
    }

    public String getHotTag() {
        return hotTag;
    }

    public void setHotTag(String hotTag) {
        this.hotTag = hotTag;
    }

    public String getHotTagImg() {
        return hotTagImg;
    }

    public void setHotTagImg(String hotTagImg) {
        this.hotTagImg = hotTagImg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRawUrl() {
        return rawUrl;
    }

    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    public List<String> getShow() {
        return show;
    }

    public void setShow(List<String> show) {
        this.show = show;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
