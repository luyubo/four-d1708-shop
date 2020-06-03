package com.four.d1708.shop.userserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.four.d1708.shop.entityinterface.entity.ShopPay;
import com.four.d1708.shop.userserver.entity.ShopPayVo;


public interface IShop_payService extends IService<ShopPay> {

    ShopPayVo findPayByUid(Integer uid);

    ShopPayVo getPayByAmountNumAndPassword(String account_num, String password);
}
