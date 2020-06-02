package com.four.d1780.shop.cartAndOrderServer.controller;

import com.four.d1708.shop.entityinterface.entity.ShopArea;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopAreaVo;
import com.four.d1780.shop.cartAndOrderServer.service.ShopAreaService;
import com.four.d1780.shop.cartAndOrderServer.service.ShopAreaVoService;
import com.four.d1780.shop.cartAndOrderServer.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop_Area")
public class ShopAreaVoController {
    @Autowired
    ShopAreaVoService shopAreaVoService;

    @Autowired
    ShopAreaService shopAreaService;
    @RequestMapping("findAll")
    public ResultEntity findAll(){
        return ResultEntity.ok(shopAreaVoService.findAll());
    }

    @RequestMapping("list")
    public ResultEntity list(Integer uid){
        return ResultEntity.ok(shopAreaService.list(uid));
    }

    @RequestMapping("updateAddrStateByUidAndAddrId")
    public ResultEntity updateAddrByUidAndAddrId(Integer uid,Integer addrId){
        return ResultEntity.ok(shopAreaService.updateAddrStateByUidAndAddrId(uid,addrId));
    }
}
