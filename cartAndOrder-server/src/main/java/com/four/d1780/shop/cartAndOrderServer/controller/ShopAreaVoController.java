package com.four.d1780.shop.cartAndOrderServer.controller;

import com.four.d1780.shop.cartAndOrderServer.entity.ShopAreaVo;
import com.four.d1780.shop.cartAndOrderServer.service.ShopAreaVoService;
import com.four.d1780.shop.cartAndOrderServer.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hypermarket_Area")
public class ShopAreaVoController {
    @Autowired
    ShopAreaVoService shopAreaVoService;
    @RequestMapping("findAll")
    public ResultEntity findAll(){
        return ResultEntity.ok(shopAreaVoService.findAll());
    }
}
