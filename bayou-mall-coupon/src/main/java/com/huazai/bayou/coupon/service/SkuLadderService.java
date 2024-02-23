package com.huazai.bayou.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.coupon.entity.SkuLadderEntity;

import java.util.Map;

/**
 * 商品阶梯价格
 *
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-02-21
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

