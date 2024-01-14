package org.zzb.hot.strategy;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzb.hot.domain.CollectConfig;
import org.zzb.hot.domain.CollectContent;
import org.zzb.hot.model.webo.WeboHotModel;
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
@Service(WEBO_HOT)
public class WeboHotProcessor extends CollectScheduled<WeboHotModel> {

    @Autowired
    private ICollectContentService collectContentService;

    private static final String TYPE = WEBO_HOT;

    private final Site site = Site.me().setCharset("utf-8").setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        List<String> hostList =
            new JsonPathSelector(String.valueOf(page.getRequest().getExtra(DATA_EXPRESS))).selectList(page.getRawText());
        List<WeboHotModel> weboHotModels = new ArrayList<>();
        for (String hot : hostList) {
            weboHotModels.add(JSON.parseObject(hot, WeboHotModel.class));
        }
        page.putField(DATA_NODE, weboHotModels);
    }


    @Override
    public List<CollectContent> collect(CollectConfig config, boolean save) {
        return super.collect(config, save);
    }

    @Override
    protected CollectContent transfor(CollectConfig config, WeboHotModel weboHotModel,int index) {
        CollectContent collectContent = new CollectContent();
        collectContent.setImg(null);
        collectContent.setTitle(weboHotModel.getWord());
        // 配置是否记录原始数据
        if (RECORD_DATA.equals(config.getRecordData())) {
            collectContent.setDatastr(weboHotModel.toString());
        }
        // 链接
        collectContent.setUrl(MessageFormat.format(WEBO_HOT_URL, weboHotModel.getWord()));
        collectContent.setHotMetric(weboHotModel.getRaw_hot());
        collectContent.setHotOrder(Integer.parseInt(weboHotModel.getRank()));
        collectContent.setParam(config.getCollectParam());
        collectContent.setConfigDesc(config.getConfigName());
        collectContent.setCreater("job_user");
        collectContent.setCollectId(config.getCollectId());
        collectContent.setConfigId(config.getCollectConfigId());
        return collectContent;
    }

    public List<WeboHotModel> getObj(CollectConfig config) {
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
