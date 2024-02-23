package com.huazai.bayou.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.common.utils.Query;

import com.huazai.bayou.coupon.dao.SkuLadderDao;
import com.huazai.bayou.coupon.entity.SkuLadderEntity;
import com.huazai.bayou.coupon.service.SkuLadderService;

/**
 * 商品阶梯价格
 *
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-02-21
 */
@Service("skuLadderService")
public class SkuLadderServiceImpl extends ServiceImpl<SkuLadderDao, SkuLadderEntity> implements SkuLadderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuLadderEntity> page = this.page(
                new Query<SkuLadderEntity>().getPage(params),
                new QueryWrapper<SkuLadderEntity>()
        );

        return new PageUtils(page);
    }

}