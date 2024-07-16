package com.huazai.bayou.admin.common.utils;

import java.util.HashMap;


/**
 * Map工具类
 *
 * @author Mark who.seek.me@java98k.vip
 */
public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
