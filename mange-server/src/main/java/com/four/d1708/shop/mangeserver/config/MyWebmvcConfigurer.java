package com.four.d1708.shop.mangeserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author luyubo
 * @Title: MyWebmvcConfigurer
 * @Package config
 * @Description: webmvcConfigurer静态资源处理
 * @date 2020/5/21/22:55
 * @version 1.0
 */
@Configuration
public class MyWebmvcConfigurer implements WebMvcConfigurer {

    //解决跨域的问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowCredentials(true)
                .allowedHeaders("*")
                .maxAge(3600);
    }

    //解决静态资源问题
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:D:/pic/");
    }
}
