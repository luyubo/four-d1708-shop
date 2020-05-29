package com.four.d1780.shop.cartAndOrderServer.task;

import com.four.d1780.shop.cartAndOrderServer.mapper.ShopOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class OrderTask {

    @Autowired
    ShopOrderMapper shopOrderMapper;

    private static final Logger logger = LoggerFactory.getLogger(OrderTask.class);
    @Scheduled(cron = "0/3 * * * * *")//每隔一分钟执行一次任务
    private void task1(){
        logger.info("执行任务"+System.currentTimeMillis());
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.setTime(date);
        calendar.set(GregorianCalendar.MINUTE,+43);//系统时间跟当前时间有差异58分钟 检测十五分钟后未完成的订单
        Date time = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        String format = sdf.format(date);
        System.err.println(time);
        shopOrderMapper.updateByCreateTime(time);
    }
}
