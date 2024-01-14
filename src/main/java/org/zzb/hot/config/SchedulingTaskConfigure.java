package org.zzb.hot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.zzb.hot.task.SchedulingTask;
import org.zzb.hot.task.registrar.SchedulingTaskRegistrar;

import java.util.ArrayList;
import java.util.List;

/**
 * 调度任务的自定义配置类
 */
@Configuration
@Slf4j
class SchedulingTaskConfigure implements SchedulingConfigurer, SchedulingTaskRegistrar {

    private final List<SchedulingTask> schedulingTaskList;

    private volatile ScheduledTaskRegistrar taskRegistrar;

    public SchedulingTaskConfigure() {
        // 初始化任务列表
        this.schedulingTaskList = new ArrayList<>();
    }

    // 这个方法只会调用一次
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        log.debug("configureTasks is init!");
        this.taskRegistrar = taskRegistrar;
        log.debug("configureTasks is init! = " + this.schedulingTaskList);
        taskRegistrar.setScheduler(threadPoolTaskScheduler());
        // 这里是循环去任务列表注册任务
        for (SchedulingTask schedulingTask : schedulingTaskList) {
            taskRegistrar.addTriggerTask(
                // 执行定时任务
                () -> {
                    log.debug("configureTasks is running! 执行定时任务");
                    schedulingTask.taskService();
                },
                // 设置触发器
                triggerContext -> {
                    log.debug("configureTasks is running! 设置触发器");
                    // 获取定时任务周期表达式
                    final String cron = schedulingTask.cron();
                    CronTrigger trigger = new CronTrigger(cron);
                    return trigger.nextExecutionTime(triggerContext);
                }
            );
        }
    }

    // 如果需要定时任务的支持时，就调用这个方法并传递任务的实例
    @Override
    public void add(SchedulingTask schedulingTask) {
        log.debug("this.schedulingTaskList = " + this.schedulingTaskList + ", taskRegistrar = " + this.taskRegistrar);

        if (this.taskRegistrar != null) {
            this.taskRegistrar.scheduleCronTask(
                new CronTask(() -> {
                    log.debug("configureTasks is running! 执行定时任务");
                    schedulingTask.taskService();
                },
                schedulingTask.cron()
                ));
            return;
        }
        this.schedulingTaskList.add(schedulingTask);
    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(Runtime.getRuntime().availableProcessors() / 3 + 1);
        scheduler.setThreadNamePrefix("collect-scheduler-");
        scheduler.setRemoveOnCancelPolicy(true);
        return scheduler;
    }
}
