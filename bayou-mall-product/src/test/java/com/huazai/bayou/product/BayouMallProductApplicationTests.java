package com.huazai.bayou.product;

import com.alibaba.druid.sql.repository.SchemaObjectType;
import com.huazai.bayou.product.entity.CategoryEntity;
import com.huazai.bayou.product.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
