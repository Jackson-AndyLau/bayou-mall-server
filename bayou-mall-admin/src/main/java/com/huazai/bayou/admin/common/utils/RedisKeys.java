package com.huazai.bayou.admin.common.utils;

/**
 * Redis所有Keys
 *
 * @author Mark who.seek.me@java98k.vip
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
