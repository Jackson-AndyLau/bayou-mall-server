package com.huazai.bayou.admin.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.admin.common.utils.PageUtils;
import com.huazai.bayou.admin.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 *
 * @author Mark who.seek.me@java98k.vip
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
