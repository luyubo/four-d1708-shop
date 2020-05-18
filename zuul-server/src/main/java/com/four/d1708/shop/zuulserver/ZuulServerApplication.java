package com.four.d1708.shop.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @author luyubo
 * @Title: ZuulServerApplication
 * @Package zuulserver
 * @Description: ZuulServer的网关服务
 * @date 2020/5/1821:21
 */
@EnableZuulServer
@EnableEurekaClient
@SpringBootApplication
public class ZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class,args);
    }
}
