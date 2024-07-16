package com.huazai.bayou.admin.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huazai.bayou.admin.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 *
 * @author Mark who.seek.me@java98k.vip
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
