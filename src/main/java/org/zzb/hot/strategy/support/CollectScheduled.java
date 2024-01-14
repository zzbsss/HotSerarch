package org.zzb.hot.strategy.support;


import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.zzb.hot.domain.CollectConfig;
import org.zzb.hot.domain.CollectContent;
import org.zzb.hot.domain.CollectWeb;
import org.zzb.hot.model.RequestConfig;
import org.zzb.hot.service.ICollectContentService;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.MessageFormat;
import java.util.*;

@Slf4j
public abstract class CollectScheduled<T> implements PageProcessor {

    /**
     * 采集url
     */
    protected String collectUrl;

    private ICollectContentService collectContentService;

    public static final String DATA_EXPRESS = "dataExpress";

    public static final String DATA_NODE = "data";

    public void init(CollectWeb collectWeb, ICollectContentService collectContentService){
        collectUrl = collectWeb.getCollectEndpoint();
        this.collectContentService = collectContentService;
    }

    protected abstract boolean support(String type);

    /**
     * 通过配置获取热搜数据
     * @param config
     * @return
     */
    protected List<T> getObj(CollectConfig config){
        // 添加附加参数
        Request request = new Request();
        Map<String, Object> ext = new HashMap<>(8);
        ext.put(DATA_EXPRESS, config.getCollectExpression());
        String requestConfig = config.getRequestConfig();
        // 配置了请求
        try {
            if (StringUtils.isNotBlank(requestConfig)) {
                RequestConfig requestConfigDTO = JSON.parseObject(requestConfig, RequestConfig.class);
                // 请求类型
                if (StringUtils.isNotBlank(requestConfigDTO.getRequestType())) {
                    request.setMethod(requestConfigDTO.getRequestType());
                }
                // 请求cookie
                if(CollectionUtil.isNotEmpty(requestConfigDTO.getCookies())){
                    Map<String, Object> cookies = requestConfigDTO.getCookies();
                    cookies.forEach((k,v)-> request.addCookie(k, String.valueOf(v)));
                }
                // 请求头
                if(CollectionUtil.isNotEmpty(requestConfigDTO.getHeaders())){
                    Map<String, Object> headers = requestConfigDTO.getHeaders();
                    headers.forEach((k,v)-> request.addHeader(k, String.valueOf(v)));
                }
                // 请求体
                if(StringUtils.isNotBlank(requestConfigDTO.getRequestBody())){
                    String requestBody = requestConfigDTO.getRequestBody();
                    request.setRequestBody(HttpRequestBody.json(requestBody, "utf-8"));
                }
            }
        } catch (Exception e) {
            log.error("请求模版解析错误，请检查配置{}", requestConfig);
            throw new RuntimeException(e);
        }
        String collectParam = config.getCollectParam();
        // url格式化
        String url = StringUtils.isNotBlank(collectParam)
            ? MessageFormat.format(collectUrl, Arrays.stream(config.getCollectParam().split(",")).toArray())
            : collectUrl;
        request.setUrl(url);
        request.setExtras(ext);
        ResultItems resultItems = Spider.create(this)
            .thread(5).addRequest(request)
            .get(url);
        if (Objects.isNull(resultItems) || Objects.isNull(resultItems.get(DATA_NODE))) {
            return new ArrayList<T>();
        }
        return resultItems.get(DATA_NODE);
    }

    /**
     * 转换
     * @param config
     * @param t
     * @return
     */
    protected abstract CollectContent transfor(CollectConfig config, T t, int index);

    /**
     * 收集
     * @param config
     * @param save
     * @return
     */
    public List<CollectContent> collect(CollectConfig config, boolean save){
        List<T> hotObj = getObj(config);
        int maxCount = config.getMaxCount();
        List<CollectContent> res = new ArrayList<>();
        for (int i = 0; i < hotObj.size(); i++) {
            //超过记录最大条数，跳出
            if (maxCount > 0 && i+1 > maxCount) {
                break;
            }
            CollectContent collectContent = transfor(config, hotObj.get(i), i);
            res.add(collectContent);
            if (save) {
                collectContentService.insertCollectContent(collectContent);
            }
        }
        return res;
    }
}
