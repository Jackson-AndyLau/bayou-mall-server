package com.huazai.bayou.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.common.utils.Query;
import com.huazai.bayou.product.dao.CategoryDao;
import com.huazai.bayou.product.entity.CategoryEntity;
import com.huazai.bayou.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品三级分类
 * <p>
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-07-15
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> queryTree(Map<String, Object> params) {
        // 1、查询所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        // 2、组装分类属性结构
        // 2.1 获取所有的父级分类level0
        List<CategoryEntity> menuLevel0 = categoryEntities.stream().filter(categoryEntity01 ->
                categoryEntity01.getParentCid() != null && categoryEntity01.getParentCid() == 0
        ).map(categoryEntity02 -> {
            // 2.2 获取所有的子级分类
            categoryEntity02.setChildrenList(this.getChildrenCategoryList(categoryEntity02, categoryEntities));
            return categoryEntity02;
        }).sorted(Comparator.comparing(CategoryEntity::getSort, Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList());

        return menuLevel0;
    }

    /**
     * 递归获取子级分类
     *
     * @param menuLevel0       父级分类
     * @param categoryEntities 分类集合
     * @return
     */
    private List<CategoryEntity> getChildrenCategoryList(CategoryEntity menuLevel0, List<CategoryEntity> categoryEntities) {
        List<CategoryEntity> childrenCategoryList = categoryEntities.stream().filter(categoryEntity01 ->
                categoryEntity01.getParentCid() == menuLevel0.getCatId()
        ).map(categoryEntity02 -> {
            categoryEntity02.setChildrenList(this.getChildrenCategoryList(categoryEntity02, categoryEntities));
            return categoryEntity02;
        }).sorted(Comparator.comparing(CategoryEntity::getSort, Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList());

        return childrenCategoryList;
    }

    /**
     * 查询属性分组的完整路径
     *
     * @param catelogId
     * @return 完整路径
     */
    @Override
    public Long[] queryCatelogPathByCatelogId(Long catelogId) {
        List<Long> catelogIds = new ArrayList<>();
        findParentCatelogIds(catelogId, catelogIds);

        // 排序
        List<Long> resultCatelogIds = catelogIds.stream().sorted().collect(Collectors.toList());
        // List<Long> resultCatelogIds = catelogIds.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        // 类型转换
        return resultCatelogIds.stream().toArray(Long[]::new);
    }

    private void findParentCatelogIds(Long catelogId, List<Long> catelogIds) {
        // 当前节点ID
        catelogIds.add(catelogId);

        CategoryEntity categoryEntity = this.getById(catelogId);
        // 0 为顶级父级节点
        if (categoryEntity.getParentCid() != 0) {

            this.findParentCatelogIds(categoryEntity.getParentCid(), catelogIds);
        }
    }
}