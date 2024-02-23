package com.huazai.bayou.coupon;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huazai.bayou.coupon.entity.CouponEntity;
import com.huazai.bayou.coupon.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class BayouMallCouponApplicationTests {

    @Autowired
    private CouponService couponService;

    @Test
    void contextLoads() {

        // 新增
/*        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("名酒优惠券");
        couponEntity.setNum(1000);
        couponEntity.setAmount(new BigDecimal(10000));
        couponEntity.setPerLimit(5);

        couponService.save(couponEntity);*/

        // 查询
        QueryWrapper<CouponEntity> couponEntityQueryWrapper = new QueryWrapper<>();
        couponEntityQueryWrapper.lambda().like(CouponEntity::getCouponName, "名酒");
        List<CouponEntity> couponEntityList = couponService.list(couponEntityQueryWrapper);

        couponEntityList.forEach(couponEntity -> {
            System.out.println(couponEntity.toString());

        });
    }

}
