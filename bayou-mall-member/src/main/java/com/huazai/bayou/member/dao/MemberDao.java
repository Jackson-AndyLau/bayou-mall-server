package com.huazai.bayou.member.dao;

import com.huazai.bayou.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 *
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-02-21
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
