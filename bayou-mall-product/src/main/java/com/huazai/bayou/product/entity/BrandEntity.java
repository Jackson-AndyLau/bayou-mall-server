package com.huazai.bayou.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.*;
import lombok.Data;
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
    @TableId
    private Long brandId;
    /**
     * 品牌名
     */
    @NotEmpty(message = "品牌名不能为空！")
    private String name;
    /**
     * 品牌logo地址
     */
    @NotEmpty(message = "品牌logo地址不能为空！")
    @URL
    private String logo;
    /**
     * 介绍
     */
    @NotEmpty(message = "品牌介绍不能为空！")
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    @Min(value = 0, message = "品牌的显示状态必须是正整数！")
    @NotNull(message = "品牌显示状态不能为空！")
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @NotEmpty(message = "品牌检索首字母不能为空！")
    @Pattern(regexp = "[a-zA-Z]", message = "品牌检索首字母必须是一个英文字母")
    private String firstLetter;
    /**
     * 排序
     */
    @Min(message = "品牌排序必须是正整数！", value = 0)
    @NotNull(message = "品牌排序不能为空！")
    private Integer sort;

}
