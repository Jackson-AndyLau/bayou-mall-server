package com.huazai.bayou.admin.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huazai.bayou.admin.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Mark who.seek.me@java98k.vip
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
