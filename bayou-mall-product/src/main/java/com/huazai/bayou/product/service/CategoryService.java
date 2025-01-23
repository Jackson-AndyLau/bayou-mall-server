package com.huazai.bayou.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 * <p>
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-07-15
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取分类树结构
     */
    List<CategoryEntity> queryTree(Map<String, Object> params);

    /**
     * 查询属性分组的完整路径
     *
     * @param catelogId
     * @return 完整路径
     */
    Long[] queryCatelogPathByCatelogId(Long catelogId);
}

