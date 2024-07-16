package com.huazai.bayou.admin.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author Mark who.seek.me@java98k.vip
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
