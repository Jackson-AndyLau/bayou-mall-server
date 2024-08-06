package com.huazai.bayou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * ClassName: BayouMallCorsConfiguration
 * Package: com.huazai.bayou.gateway.config
 * Description:
 *
 * @Author huazai
 * @Create 2024-07-19 15:17
 * @Version 1.0
 */
@Configuration
public class MyCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 跨域配置
        // 放行全部原始头信息
        corsConfiguration.addAllowedHeader("*");
        // 允许所有请求方法跨域调用
        corsConfiguration.addAllowedMethod("*");
        // 允许所有域名进行跨域调用
        corsConfiguration.addAllowedOriginPattern("*");
        // 允许跨域发送cookie
        corsConfiguration.setAllowCredentials(true);

        // 对所有路径应用 CORS 配置
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(urlBasedCorsConfigurationSource);
    }
}
