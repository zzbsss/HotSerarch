package org.zzb.hot.model.douyin;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class DouyinHotModel implements Serializable {

    private String article_detail_count;
    private String aweme_infos;
    private String can_extend_detail;
    private String discuss_video_count;
    private String display_style;
    private String drift_info;
    private String emo_label;
    private String event_time;
    private String group_id;
    private String hot_value;
    private String hotlist_param;
    private String label;
    private String position;
    private String related_words;
    private String sentence_id;
    private String sentence_tag;
    private String video_count;
    private String view_count;
    private String word;
    private WordCover word_cover;
    private String word_sub_board;
    private String word_type;

    public String getArticle_detail_count() {
        return article_detail_count;
    }

    public void setArticle_detail_count(String article_detail_count) {
        this.article_detail_count = article_detail_count;
    }

    public String getAweme_infos() {
        return aweme_infos;
    }

    public void setAweme_infos(String aweme_infos) {
        this.aweme_infos = aweme_infos;
    }

    public String getCan_extend_detail() {
        return can_extend_detail;
    }

    public void setCan_extend_detail(String can_extend_detail) {
        this.can_extend_detail = can_extend_detail;
    }

    public String getDiscuss_video_count() {
        return discuss_video_count;
    }

    public void setDiscuss_video_count(String discuss_video_count) {
        this.discuss_video_count = discuss_video_count;
    }

    public String getDisplay_style() {
        return display_style;
    }

    public void setDisplay_style(String display_style) {
        this.display_style = display_style;
    }

    public String getDrift_info() {
        return drift_info;
    }

    public void setDrift_info(String drift_info) {
        this.drift_info = drift_info;
    }

    public String getEmo_label() {
        return emo_label;
    }

    public void setEmo_label(String emo_label) {
        this.emo_label = emo_label;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getHot_value() {
        return hot_value;
    }

    public void setHot_value(String hot_value) {
        this.hot_value = hot_value;
    }

    public String getHotlist_param() {
        return hotlist_param;
    }

    public void setHotlist_param(String hotlist_param) {
        this.hotlist_param = hotlist_param;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRelated_words() {
        return related_words;
    }

    public void setRelated_words(String related_words) {
        this.related_words = related_words;
    }

    public String getSentence_id() {
        return sentence_id;
    }

    public void setSentence_id(String sentence_id) {
        this.sentence_id = sentence_id;
    }

    public String getSentence_tag() {
        return sentence_tag;
    }

    public void setSentence_tag(String sentence_tag) {
        this.sentence_tag = sentence_tag;
    }

    public String getVideo_count() {
        return video_count;
    }

    public void setVideo_count(String video_count) {
        this.video_count = video_count;
    }

    public String getView_count() {
        return view_count;
    }

    public void setView_count(String view_count) {
        this.view_count = view_count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public WordCover getWord_cover() {
        return word_cover;
    }

    public void setWord_cover(WordCover word_cover) {
        this.word_cover = word_cover;
    }

    public String getWord_sub_board() {
        return word_sub_board;
    }

    public void setWord_sub_board(String word_sub_board) {
        this.word_sub_board = word_sub_board;
    }

    public String getWord_type() {
        return word_type;
    }

    public void setWord_type(String word_type) {
        this.word_type = word_type;
    }
}
