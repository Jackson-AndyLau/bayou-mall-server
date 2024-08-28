package com.huazai.bayou.product.controller;

import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.common.utils.R;
import com.huazai.bayou.product.entity.CategoryEntity;
import com.huazai.bayou.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 商品三级分类
 * <p>
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-07-15
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 获取分类树结构
     */
    @RequestMapping("/tree")
    public R tree(@RequestParam Map<String, Object> params) {
        List<CategoryEntity> categoryEntities = categoryService.queryTree(params);

        return R.ok().put("treeList", categoryEntities);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category) {
        categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category) {
        categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds) {

        categoryService.removeBatchByIds(Arrays.asList(catIds));

        return R.ok();
    }

    /**
     * 节点排序
     */
    @RequestMapping("/reSort")
    public R delete(@RequestBody CategoryEntity[] categoryEntities) {

        categoryService.updateBatchById(Arrays.asList(categoryEntities));

        return R.ok();
    }

}
