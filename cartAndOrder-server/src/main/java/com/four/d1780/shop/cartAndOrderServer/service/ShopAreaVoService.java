package com.four.d1780.shop.cartAndOrderServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopAreaVo;

import java.util.List;


public interface ShopAreaVoService  {


    List<ShopAreaVo> findAll();
}
