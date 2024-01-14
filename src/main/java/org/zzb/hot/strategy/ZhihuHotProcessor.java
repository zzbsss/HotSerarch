package org.zzb.hot.strategy;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzb.hot.domain.CollectConfig;
import org.zzb.hot.domain.CollectContent;
import org.zzb.hot.model.zhihu.ZhihuHotModel;
import org.zzb.hot.service.ICollectContentService;
import org.zzb.hot.strategy.support.CollectScheduled;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.util.ArrayList;
import java.util.List;

import static org.zzb.hot.constant.CollectConstant.*;


@Slf4j
@Service(ZHIHU_HOT)
public class ZhihuHotProcessor extends CollectScheduled<ZhihuHotModel> {

    @Autowired
    private ICollectContentService collectContentService;

    private static final String TYPE = ZHIHU_HOT;

    private final Site site = Site.me().setCharset("utf-8").setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        // 分析知乎热搜得知 ，热搜数据在一个 js 脚本里面
        String res = page.getHtml().xpath(ZHIHU_XPATH_DATA).get();
        // 解析热搜数据
        List<String> hostList = new JsonPathSelector(String.valueOf(page.getRequest().getExtra(DATA_EXPRESS))).selectList(res);
        List<ZhihuHotModel> zhihuHotModels = new ArrayList<>();
        for (String hot : hostList) {
            zhihuHotModels.add(JSON.parseObject(hot, ZhihuHotModel.class));
        }
        page.putField(DATA_NODE, zhihuHotModels);
    }


    @Override
    public List<CollectContent> collect(CollectConfig config, boolean save) {
       return super.collect(config, save);
    }

    @Override
    protected CollectContent transfor(CollectConfig config, ZhihuHotModel zhihuHotModel,int index) {
        CollectContent collectContent = new CollectContent();
        collectContent.setImg(null);
        collectContent.setTitle(zhihuHotModel.getTarget().getTitleArea().getString("text"));
        // 配置是否记录原始数据
        if (RECORD_DATA.equals(config.getRecordData())) {
            collectContent.setDatastr(zhihuHotModel.toString());
        }
        collectContent.setImg(zhihuHotModel.getTarget().getImageArea().getString("url"));
        // 链接
        collectContent.setUrl(zhihuHotModel.getTarget().getLink().getString("url"));
        collectContent.setHotMetric(zhihuHotModel.getTarget().getMetricsArea().getString("text"));
        // 使用默认排序
        collectContent.setHotOrder(index);
        collectContent.setParam(config.getCollectParam());
        collectContent.setConfigDesc(config.getConfigName());
        collectContent.setCreater("job_user");
        collectContent.setCollectId(config.getCollectId());
        collectContent.setConfigId(config.getCollectConfigId());
        return collectContent;
    }

    public List<ZhihuHotModel> getObj(CollectConfig config) {
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
