package com.four.d1780.shop.cartAndOrderServer.service.impl;

import com.four.d1780.shop.cartAndOrderServer.entity.ShopAreaVo;
import com.four.d1780.shop.cartAndOrderServer.mapper.ShopAreaVoMapper;
import com.four.d1780.shop.cartAndOrderServer.service.ShopAreaVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopAreaVoServiceImpl implements ShopAreaVoService {

    @Autowired
    ShopAreaVoMapper shopAreaVoMapper;

    @Override
    public List<ShopAreaVo> findAll() {
        return shopAreaVoMapper.findAll();
    }
}
