package com.four.d1708.shop.userserver.entity;

import lombok.Data;

import java.util.List;

/**
 * @author luyubo
 * @Title: ShopAreaVo
 * @Package entity
 * @Description: 地址查询
 * @date 2020/6/3/18:56
 * @Version 1.0
 */
@Data
public class ShopAreaVo {
    private Integer id;
    private String name;
    private List<ShopAreaVo> list;
}
