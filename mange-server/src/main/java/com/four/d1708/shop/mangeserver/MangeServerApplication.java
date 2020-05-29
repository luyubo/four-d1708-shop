package com.four.d1708.shop.mangeserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author luyubo
 * @Title: MangeServerApplication
 * @Package mangeserver
 * @Description: mange服务的启动类
 * @date 2020/5/21/8:05
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.four.d1708.shop.mangeserver.mapper")
public class MangeServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangeServerApplication.class,args);
    }
}
