package org.zzb.hot.task.registrar;

import org.zzb.hot.task.SchedulingTask;

/**
 * 对外暴露的定时任务注册接口
 */
public interface SchedulingTaskRegistrar {

    // 注册定时任务
    void add(SchedulingTask schedulingTask);

}

