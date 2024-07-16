package com.huazai.bayou.admin.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.admin.common.utils.PageUtils;
import com.huazai.bayou.admin.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author Mark who.seek.me@java98k.vip
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}
