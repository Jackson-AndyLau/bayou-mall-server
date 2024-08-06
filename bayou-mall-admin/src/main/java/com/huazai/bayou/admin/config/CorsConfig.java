package com.huazai.bayou.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class CorsConfig implements WebMvcConfigurer {

//    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 允许所有域名进行跨域调用
            .allowedOriginPatterns("*")
                // 允许跨域发送cookie
            .allowCredentials(true)
                // 放行全部原始头信息
            .allowedHeaders("*")
                // 允许所有请求方法跨域调用
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 预检请求，结果
            .maxAge(3600);
    }
}
