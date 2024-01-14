package org.zzb.hot.strategy;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.zzb.hot.domain.CollectConfig;
import org.zzb.hot.domain.CollectContent;
import org.zzb.hot.model.baidu.BaiduHotModel;
import org.zzb.hot.strategy.support.CollectScheduled;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.util.ArrayList;
import java.util.List;

import static org.zzb.hot.constant.CollectConstant.BAIDU_HOT;
import static org.zzb.hot.constant.CollectConstant.RECORD_DATA;


@Slf4j
@Service(BAIDU_HOT)
public class BaiduHotProcessor extends CollectScheduled<BaiduHotModel> {

    private static final String TYPE = BAIDU_HOT;

    private final Site site = Site.me().setCharset("utf-8").setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        List<String> hostList =
            new JsonPathSelector(String.valueOf(page.getRequest().getExtra(DATA_EXPRESS))).selectList(page.getRawText());
        List<BaiduHotModel> baiduHotModels = new ArrayList<>();
        for (String hot : hostList) {
            baiduHotModels.add(JSON.parseObject(hot, BaiduHotModel.class));
        }
        page.putField(DATA_NODE, baiduHotModels);
    }


    @Override
    public List<CollectContent> collect(CollectConfig config,boolean save) {
      return super.collect(config,save);
    }

    @Override
    public  CollectContent transfor(CollectConfig config,
        BaiduHotModel baiduHotModel,int index) {
        CollectContent collectContent = new CollectContent();
        collectContent.setImg(baiduHotModel.getImg());
        collectContent.setTitle(baiduHotModel.getWord());
        // 配置是否记录原始数据
        if (RECORD_DATA.equals(config.getRecordData())) {
            collectContent.setDatastr(baiduHotModel.toString());
        }
        collectContent.setUrl(baiduHotModel.getUrl());
        collectContent.setHotMetric(baiduHotModel.getHotScore());
        collectContent.setHotOrder(Integer.parseInt(baiduHotModel.getIndex()));
        collectContent.setParam(config.getCollectParam());
        collectContent.setConfigDesc(config.getConfigName());
        collectContent.setCollectId(config.getCollectId());
        collectContent.setConfigId(config.getCollectConfigId());
        collectContent.setCreater("job_user");
        return collectContent;
    }

    public List<BaiduHotModel> getObj(CollectConfig config) {
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
