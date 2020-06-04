package com.four.d1780.shop.cartAndOrderServer.service;

import com.four.d1708.shop.entityinterface.entity.ShopOrder;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopOrderVo;

import java.util.List;

public interface ShopOrderService {

    List<ShopOrderVo> findAll(Integer uid);

    int generateOrder(Integer uid,String cids);

    boolean saveOrder(ShopOrder shopOrder);
}
