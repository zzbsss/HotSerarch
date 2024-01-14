package org.zzb.hot.strategy;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzb.hot.domain.CollectConfig;
import org.zzb.hot.domain.CollectContent;
import org.zzb.hot.model.douyin.DouyinHotModel;
import org.zzb.hot.service.ICollectContentService;
import org.zzb.hot.strategy.support.CollectScheduled;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static org.zzb.hot.constant.CollectConstant.*;


@Slf4j
@Service(DOUYIN_HOT)
public class DouyinHotProcessor extends CollectScheduled<DouyinHotModel> {

    @Autowired
    private ICollectContentService collectContentService;

    private static final String TYPE = DOUYIN_HOT;

    private final Site site = Site.me().setCharset("utf-8").setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        List<String> hostList =
            new JsonPathSelector(String.valueOf(page.getRequest().getExtra(DATA_EXPRESS))).selectList(page.getRawText());
        List<DouyinHotModel> baiduHotModels = new ArrayList<>();
        for (String hot : hostList) {
            baiduHotModels.add(JSON.parseObject(hot, DouyinHotModel.class));
        }
        page.putField(DATA_NODE, baiduHotModels);
    }


    @Override
    public List<CollectContent> collect(CollectConfig config, boolean save) {
        return super.collect(config,save);
    }

    @NotNull
    public  CollectContent transfor(CollectConfig config,
        DouyinHotModel douyinHotModel,int index) {
        CollectContent collectContent = new CollectContent();
        collectContent.setImg(
            CollectionUtil.join(douyinHotModel.getWord_cover().getUrl_list(), "||"));
        collectContent.setTitle(douyinHotModel.getWord());
        // 配置是否记录原始数据
        if (RECORD_DATA.equals(config.getRecordData())) {
            collectContent.setDatastr(douyinHotModel.toString());
        }
        // 链接
        collectContent.setUrl(MessageFormat.format(DOUYI_HOT_URL, douyinHotModel.getSentence_id()));
        collectContent.setHotMetric(douyinHotModel.getHot_value());
        collectContent.setHotOrder(Integer.parseInt(douyinHotModel.getPosition()));
        collectContent.setParam(config.getCollectParam());
        collectContent.setConfigDesc(config.getConfigName());
        collectContent.setCreater("job_user");
        collectContent.setCollectId(config.getCollectId());
        collectContent.setConfigId(config.getCollectConfigId());
        return collectContent;
    }

    public List<DouyinHotModel> getObj(CollectConfig config) {
      return super.getObj(config);
    }

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public boolean support(String type) {
        return StringUtils.isNotBlank(type) && type.equals(TYPE);
    }

}
