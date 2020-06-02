package com.four.d1780.shop.cartAndOrderServer.entity;

import com.four.d1708.shop.entityinterface.entity.ShopAddr;
import lombok.Data;

@Data
public class ShopAddrVo extends ShopAddr {
    private String sheng;
    private String shi;
    private String qu;
}
