package com.four.d1708.shop.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author luyubo
 * @Title: EurekaServerApplication
 * @Package eurekaserver
 * @Description: EurekaServer注册中心的启动类
 * @date 2020/5/1821:09
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
