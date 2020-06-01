package com.four.d1780.shop.cartAndOrderServer.service;

import com.four.d1708.shop.entityinterface.entity.ShopArea;

import java.util.List;

public interface ShopAreaService {

    List<ShopArea> list(Integer uid);

    int updateAddrStateByUidAndAddrId(Integer uid, Integer addrId);
}
