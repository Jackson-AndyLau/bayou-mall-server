package com.huazai.bayou.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.coupon.entity.CouponHistoryEntity;

import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-02-21
 */
public interface CouponHistoryService extends IService<CouponHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

