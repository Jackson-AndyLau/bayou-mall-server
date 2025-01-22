package com.huazai.bayou.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 * <p>
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-07-15
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    /**
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 列表(分类属性列表查询)
     *
     * @param params    查询参数
     * @param catelogId 所属分类ID
     * @return 分页分类属性列表数据
     */
    PageUtils queryPage(Map<String, Object> params, Long catelogId);
}

