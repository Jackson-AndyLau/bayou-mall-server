package com.huazai.bayou.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.common.utils.Query;
import com.huazai.bayou.product.dao.CategoryDao;
import com.huazai.bayou.product.entity.CategoryEntity;
import com.huazai.bayou.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author by huazai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-01-18 15:48:00
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

}