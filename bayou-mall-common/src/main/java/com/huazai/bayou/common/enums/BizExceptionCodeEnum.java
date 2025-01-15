package com.huazai.bayou.common.enums;

import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName: BizExceptionEnum
 * Package: com.huazai.bayou.common.enums
 * Description:
 *
 * @Author HuaZai
 * @Create 2025-01-15 15:26
 * @Version 1.0
 */
public enum BizExceptionCodeEnum {
    /**
     * 11 商品异常代码
     */
    PRODUCT_VALID_ERROR(110001, "参数校验失败！"),

    /**
     * 12 订单异常代码
     */

    /**
     *13 购物车异常代码
     */

    /**
     * 14 会员异常代码
     */
    /* 系统内部错误：1001、1002 */
    INSIDE_GET_BY_CODE_ERROR(1001, "CODE码不存在"),
    INSIDE_GET_BY_NAME_ERROR(1002, "NAME不存在");

    private Integer code;
    private String name;

    BizExceptionCodeEnum() {
    }

    BizExceptionCodeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * 获取List枚举数组
     */
    public static List<BizExceptionCodeEnum> getBizExceptionCodeEnumList() {
        List<BizExceptionCodeEnum> responseCodeEnumList = Stream.of(BizExceptionCodeEnum.values()).collect(Collectors.toList());

        return responseCodeEnumList;
    }

    /**
     * 根据CODE获取枚举
     *
     * @param code
     * @return
     */
    public static BizExceptionCodeEnum getBizExceptionCodeEnumByCode(Integer code) {

        if (ObjectUtils.isEmpty(code)) {
            BizExceptionCodeEnum responseCodeEnum = Arrays.stream(BizExceptionCodeEnum.values()).filter(param -> param.getCode() == code).findFirst().orElse(BizExceptionCodeEnum.INSIDE_GET_BY_CODE_ERROR);

            return responseCodeEnum;
        }
        return BizExceptionCodeEnum.INSIDE_GET_BY_CODE_ERROR;
    }

    /**
     * 根据NAME获取枚举
     *
     * @param name
     * @return
     */
    public static BizExceptionCodeEnum getBizExceptionCodeEnumByName(String name) {

        if (ObjectUtils.isEmpty(name)) {
            BizExceptionCodeEnum responseCodeEnum = Arrays.stream(BizExceptionCodeEnum.values()).filter(param -> param.getName() == name).findFirst().orElse(BizExceptionCodeEnum.INSIDE_GET_BY_NAME_ERROR);

            return responseCodeEnum;
        }
        return BizExceptionCodeEnum.INSIDE_GET_BY_NAME_ERROR;
    }
}
