package com.four.d1708.shop.mangeserver.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luyubo
 * @Title: MyBatisConfig
 * @Package config
 * @Description: MyBatisConfig
 * @date 2020/3/3022:48
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public PaginationInterceptor page(){
        return new PaginationInterceptor();
    }
}
