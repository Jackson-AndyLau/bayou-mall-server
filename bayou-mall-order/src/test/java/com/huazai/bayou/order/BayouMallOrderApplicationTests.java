package com.huazai.bayou.order;

import com.huazai.bayou.order.entity.RefundInfoEntity;
import com.huazai.bayou.order.service.RefundInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BayouMallOrderApplicationTests {

    @Autowired
    private RefundInfoService refundInfoService;

    @Test
    void contextLoads() {
/*        RefundInfoEntity refundInfoEntity = new RefundInfoEntity();
        refundInfoEntity.setOrderReturnId(1001L);
        refundInfoEntity.setRefund(BigDecimal.valueOf(1001.982));
        refundInfoEntity.setRefundSn("KM-1982");
        refundInfoEntity.setRefund(BigDecimal.valueOf(1001.982));
        refundInfoService.save(refundInfoEntity);*/

        Map<String, Object> params = new HashMap<>();
        List<?> list = refundInfoService.queryPage(params).getList();
        list.stream().forEach(obj ->{
            RefundInfoEntity refundInfoEntity = (RefundInfoEntity) obj;
            System.out.println(refundInfoEntity);
        });
    }

}
