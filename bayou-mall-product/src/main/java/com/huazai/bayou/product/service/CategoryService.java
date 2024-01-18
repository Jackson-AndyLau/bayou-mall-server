package com.huazai.bayou.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.product.entity.CategoryEntity;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author huazai
 * @email who.seek.me@java98k.vip
 * @date 2024-01-18 15:48:00
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

