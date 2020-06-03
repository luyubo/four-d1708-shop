package com.four.d1708.shop.userserver.entity;

import com.four.d1708.shop.entityinterface.entity.ShopAddr;
import lombok.Data;

/**
 * @author luyubo
 * @Title: ShopAddrVo
 * @Package entity
 * @Description: 个人地址
 * @date 2020/6/3/16:13
 * @Version 1.0
 */
@Data
public class ShopAddrVo extends ShopAddr {
    private String pname;
    private String cname;
    private String coname;
}
