package com.huazai.bayou.admin.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.admin.common.utils.PageUtils;
import com.huazai.bayou.admin.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Mark who.seek.me@java98k.vip
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
