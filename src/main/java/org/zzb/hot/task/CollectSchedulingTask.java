package org.zzb.hot.task;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StopWatch;
import org.zzb.hot.domain.CollectConfig;
import org.zzb.hot.domain.CollectWeb;
import org.zzb.hot.strategy.support.CollectScheduled;

import java.text.MessageFormat;

@Slf4j
public class CollectSchedulingTask implements SchedulingTask {

    private final CollectWeb collectWeb;

    private final CollectConfig config;

    private final CollectScheduled<?> collectScheduled;

    public CollectSchedulingTask(CollectScheduled<?> collectScheduled, CollectWeb collectWeb, CollectConfig config) {
        this.collectScheduled = collectScheduled;
        this.collectWeb = collectWeb;
        this.config = config;
    }

    @Override
    public void taskService() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(MessageFormat.format("采集任务{0},采集参数{1}",  collectWeb.getCollectCode(),config.getCollectParam()));
        collectScheduled.collect(config, true);
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
    }

    @Override
    public String cron() {
        String cron = config.getCron();
        return StringUtils.isNotBlank(cron) ? cron : "0 */1 * * * ?";
    }
}
