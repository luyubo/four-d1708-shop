package com.four.d1708.shop.zuulserver.config;

<<<<<<< Updated upstream

=======
import org.springframework.boot.web.servlet.FilterRegistrationBean;
>>>>>>> Stashed changes
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
<<<<<<< Updated upstream
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author luyubo
 * @Title: CorsConfig
 * @Package config
 * @Description: CorsConfig
 * @date 2020/4/2623:13
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
    /**
     * 跨域处理
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*");
    }

    /**
     * 处理跨域问题
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);

    }

=======

import java.util.Arrays;

/**
 * 跨域配置类
 */
@Configuration
public class CorsConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        //跨域配置
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setMaxAge(3600L);
        source.registerCorsConfiguration("/**",corsConfiguration);
        //配置过滤器
        CorsFilter corsFilter = new CorsFilter(source);
        //注册过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(corsFilter);
        filterRegistrationBean.setOrder(0);
        return filterRegistrationBean;
    }
>>>>>>> Stashed changes
}
