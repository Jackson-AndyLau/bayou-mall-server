package com.huazai.bayou.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * 专题商品
 *
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-02-21
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

