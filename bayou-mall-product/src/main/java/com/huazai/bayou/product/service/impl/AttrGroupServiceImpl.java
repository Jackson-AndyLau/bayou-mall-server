package com.huazai.bayou.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.common.utils.Query;
import com.huazai.bayou.product.dao.AttrGroupDao;
import com.huazai.bayou.product.entity.AttrGroupEntity;
import com.huazai.bayou.product.service.AttrGroupService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 属性分组
 * <p>
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-07-15
 */
@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 列表(分类属性列表查询)
     *
     * @param params    查询参数
     * @param catelogId 所属分类ID
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        if (ObjectUtils.isNotEmpty(catelogId)) {

            QueryWrapper<AttrGroupEntity> attrGroupEntityQueryWrapper = new QueryWrapper<>();
            attrGroupEntityQueryWrapper.lambda().eq(AttrGroupEntity::getCatelogId, catelogId);
            if (ObjectUtils.isNotEmpty(params)) {

                String key = String.valueOf(params.get("key"));
                attrGroupEntityQueryWrapper.and((obj) -> {
                    obj.lambda().eq(AttrGroupEntity::getAttrGroupId, key).or().like(AttrGroupEntity::getAttrGroupName, key);
                });
                IPage<AttrGroupEntity> attrGroupEntityIPage = this.page(new Query<AttrGroupEntity>().getPage(params), attrGroupEntityQueryWrapper);

                return new PageUtils(attrGroupEntityIPage);
            }
        }
        return null;
    }
}