package com.huazai.bayou.product.dao;

import com.huazai.bayou.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author huazai
 * @email who.seek.me@java98k.vip
 * @date 2024-01-18 15:48:00
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
