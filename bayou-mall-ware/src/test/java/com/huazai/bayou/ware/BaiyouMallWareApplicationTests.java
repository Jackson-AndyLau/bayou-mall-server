package com.huazai.bayou.ware;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huazai.bayou.ware.dao.WareInfoDao;
import com.huazai.bayou.ware.entity.WareInfoEntity;
import com.huazai.bayou.ware.service.WareInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BaiyouMallWareApplicationTests {

    @Autowired
    private WareInfoService wareInfoService;

    @Test
    void contextLoads() {
        // 新增仓库信息
/*        WareInfoEntity wareInfoEntity = new WareInfoEntity();
        wareInfoEntity.setAddress("四川省成都市武侯区");
        wareInfoEntity.setName("大合仓库");
        wareInfoEntity.setAreacode("100101");

        wareInfoService.save(wareInfoEntity);*/
        // 查询仓库信息
        QueryWrapper<WareInfoEntity> entityQueryWrapper = new QueryWrapper<>();
        entityQueryWrapper.lambda().eq(WareInfoEntity::getName, "大合仓库");
        List<WareInfoEntity> wareInfoEntityList = wareInfoService.list(entityQueryWrapper);
        wareInfoEntityList.stream().forEach(wareInfoEntity -> {
            System.out.println(wareInfoEntity.toString());

        });
    }

}
