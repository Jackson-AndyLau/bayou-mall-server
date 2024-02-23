package com.huazai.bayou.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-02-21
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

