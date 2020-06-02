package com.four.d1708.shop.userserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.entityinterface.entity.ShopPay;
import com.four.d1708.shop.userserver.mapper.Shop_payMapper;
import com.four.d1708.shop.userserver.service.IShop_payService;
import org.springframework.stereotype.Service;

@Service
public class Shop_payServiceImpl extends ServiceImpl<Shop_payMapper, ShopPay> implements IShop_payService {
}
