package com.huazai.bayou.product;

import com.huazai.bayou.product.entity.CategoryEntity;
import com.huazai.bayou.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class BayouMallProductApplicationTests {

    @Autowired
    CategoryService categoryService;

    @Test
    void contextLoads() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("电子书籍");
        categoryEntity.setProductCount(10000);
        categoryService.save(categoryEntity);

        System.out.println("保存执行成功。。。。");
    }

    @Test
    void queryCatelogPathByCatelogId() {

        Long[] pathByCatelogIds = categoryService.queryCatelogPathByCatelogId(174L);
        log.info("查询的属性分组：{}", Arrays.asList(pathByCatelogIds));
    }


}
