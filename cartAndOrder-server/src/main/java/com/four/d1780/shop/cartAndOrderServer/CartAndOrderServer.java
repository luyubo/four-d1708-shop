package com.four.d1780.shop.cartAndOrderServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.four.d1780.shop.cartAndOrderServer.mapper")
public class CartAndOrderServer {
    public static void main(String[] args) {
        SpringApplication.run(CartAndOrderServer.class,args);
    }
}
