package com.huazai.bayou.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.huazai.bayou.common.annotation.valid.DataStatusValid;
import com.huazai.bayou.common.valid.AddValidGroup;
import com.huazai.bayou.common.valid.UpdateValidGroup;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.EAN;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;

/**
 * 品牌
 * <p>
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-07-15
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @NotNull(message = "品牌ID不能为空！", groups = {UpdateValidGroup.class})
    @Null(message = "品牌ID必须为空！", groups = {AddValidGroup.class})
    @TableId
    private Long brandId;
    /**
     * 品牌名
     */
    @NotEmpty(message = "品牌名不能为空！", groups = {AddValidGroup.class})
    private String name;
    /**
     * 品牌logo地址
     */
    @NotEmpty(message = "品牌logo地址不能为空！", groups = {AddValidGroup.class})
    @URL(groups = {AddValidGroup.class, UpdateValidGroup.class})
    private String logo;
    /**
     * 介绍
     */
    @NotEmpty(message = "品牌介绍不能为空！", groups = {AddValidGroup.class})
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
//    @Min(value = 0, message = "品牌的显示状态必须是正整数！", groups = {AddValidGroup.class, UpdateValidGroup.class})
//    @NotNull(message = "品牌显示状态不能为空！")
    @DataStatusValid(values = {0,1},groups = AddValidGroup.class)
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @NotEmpty(message = "品牌检索首字母不能为空！", groups = {AddValidGroup.class})
    @Pattern(regexp = "[a-zA-Z]", message = "品牌检索首字母必须是一个英文字母", groups = {AddValidGroup.class, UpdateValidGroup.class})
    private String firstLetter;
    /**
     * 排序
     */
    @Min(message = "品牌排序必须是正整数！", value = 0, groups = {AddValidGroup.class, UpdateValidGroup.class})
    @NotNull(message = "品牌排序不能为空！", groups = {AddValidGroup.class})
    private Integer sort;

}
