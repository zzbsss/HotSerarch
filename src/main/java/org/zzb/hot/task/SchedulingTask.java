package org.zzb.hot.task;

/**
 * 声明任务的实例类
 */
public interface SchedulingTask {

    /**
     * 执行定时任务
     */
    void taskService();

    /**
     * cron表达式
     */
    String cron();

}
