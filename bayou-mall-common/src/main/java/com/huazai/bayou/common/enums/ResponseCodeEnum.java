package com.huazai.bayou.common.enums;

import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName: ResponseCodeEnum
 * Package: com.huazai.bayou.common.enums
 * Description:
 *
 * @Author HuaZai
 * @Create 2025-01-14 17:29
 * @Version 1.0
 */
public enum ResponseCodeEnum {
    /* 公共状态码 */
    COMMON_SUCCESS(200, "成功"),
    COMMON_FAILED(400, "失败"),
    COMMON_UNAUTHORIZED(401, "签名错误"),
    COMMON_NOT_FOUND(404, "此接口不存在"),
    COMMON_INTERNAL_SERVER_ERROR(500, "系统繁忙,请稍后再试"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),

    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    LOGIN_CREDENTIAL_EXISTED(20006, "凭证已存在"),

    //微信授权 错误码
    WEIXIN_ENCRYPT_ERROR(30001, "企业微信授权解密失败"),


    /*权限相关：40001-49999 */
    NO_PERMISS(40001, "无权限访问"),
    IS_LIMIT_ACC(40002, "访问过于频繁限制访问"),

    /* 业务错误：50001-59999 */
    WX_QRCODE_NULL(50001, "微信二维码获取内容不可用"),

    /* 业务错误：60001-69999 */
    XSS_CODE_ERROR(60001, "存在xss 恶意攻击脚本"),

    /* 系统内部错误：1001、1002 */
    INSIDE_GET_BY_CODE_ERROR(1001, "CODE码不存在"),
    INSIDE_GET_BY_NAME_ERROR(1002, "NAME不存在");


    private Integer code;

    private String name;

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

    ResponseCodeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 获取List枚举数组
     */
    public static List<ResponseCodeEnum> getResponseCodeEnumList() {
        List<ResponseCodeEnum> responseCodeEnumList = Stream.of(ResponseCodeEnum.values()).collect(Collectors.toList());

        return responseCodeEnumList;
    }

    /**
     * 根据CODE获取枚举
     *
     * @param code
     * @return
     */
    public static ResponseCodeEnum getResponseCodeEnumByCode(Integer code) {

        if (ObjectUtils.isEmpty(code)) {
            ResponseCodeEnum responseCodeEnum = Arrays.stream(ResponseCodeEnum.values()).filter(param -> param.getCode() == code).findFirst().orElse(ResponseCodeEnum.INSIDE_GET_BY_CODE_ERROR);

            return responseCodeEnum;
        }
        return ResponseCodeEnum.INSIDE_GET_BY_CODE_ERROR;
    }

    /**
     * 根据NAME获取枚举
     *
     * @param name
     * @return
     */
    public static ResponseCodeEnum getResponseCodeEnumByName(String name) {

        if (ObjectUtils.isEmpty(name)) {
            ResponseCodeEnum responseCodeEnum = Arrays.stream(ResponseCodeEnum.values()).filter(param -> param.getName() == name).findFirst().orElse(ResponseCodeEnum.INSIDE_GET_BY_NAME_ERROR);

            return responseCodeEnum;
        }
        return ResponseCodeEnum.INSIDE_GET_BY_NAME_ERROR;
    }
}
