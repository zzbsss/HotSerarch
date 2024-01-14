package org.zzb.hot.listener;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.zzb.hot.domain.CollectConfig;
import org.zzb.hot.domain.CollectWeb;
import org.zzb.hot.service.ICollectConfigService;
import org.zzb.hot.service.ICollectContentService;
import org.zzb.hot.service.ICollectWebService;
import org.zzb.hot.strategy.support.CollectScheduled;
import org.zzb.hot.task.CollectSchedulingTask;
import org.zzb.hot.task.registrar.SchedulingTaskRegistrar;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 启动时候发布初始化任务
 */
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CollectStartedListener implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private Map<String, CollectScheduled<?>> pageProcessorMap;

    @Autowired
    private ICollectConfigService collectConfigService;

    @Autowired
    private ICollectWebService collectWebService;

    @Autowired
    private ICollectContentService collectContentService;

    @Autowired
    private SchedulingTaskRegistrar schedulingTaskRegistrar;


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        // 读取数据库采集，初始化采集实现
        List<CollectWeb> collectWebs = collectWebService.selectCollectWebList(new CollectWeb());
        for (CollectWeb collectWeb : collectWebs) {
            CollectScheduled<?> collectScheduled = pageProcessorMap.get(collectWeb.getCollectCode());
            if (Objects.isNull(collectScheduled)) {
                log.warn("根据" + collectWeb.getCollectCode() + "未获取到实现");
                continue;
            }
            collectScheduled.init(collectWeb, collectContentService);
            log.debug("初始化{}采集成功" ,collectWeb.getCollectCode());
            // 初始化定时任务
            initJob(collectWeb);
        }

    }

    private void initJob(CollectWeb collectWeb) {
        CollectScheduled<?> collectScheduled = pageProcessorMap.get(collectWeb.getCollectCode());
        CollectConfig collectConfig = new CollectConfig();
        collectConfig.setCollectId(collectWeb.getCollectId());
        List<CollectConfig> collectConfigs = collectConfigService.selectCollectConfigList(collectConfig);
        if (CollectionUtil.isEmpty(collectConfigs)) {
            log.warn("根据" + collectWeb.getCollectCode() + "未获取到配置，请至少配置一个采集配置");
            return;
        }
        for (CollectConfig config : collectConfigs) {
            schedulingTaskRegistrar.add(new CollectSchedulingTask(collectScheduled, collectWeb , config));
        }
    }
}
