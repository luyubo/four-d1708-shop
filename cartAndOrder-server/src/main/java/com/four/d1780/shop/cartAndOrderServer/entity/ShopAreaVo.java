package com.four.d1780.shop.cartAndOrderServer.entity;

import com.four.d1708.shop.entityinterface.entity.ShopArea;
import lombok.Data;

import java.util.List;

@Data
public class ShopAreaVo  {

    //省市区的id
    private Integer id;
    //省市区的名称
    private String name;
    //省对应市 市对应区  的集合
    private List<ShopAreaVo> list;
}
