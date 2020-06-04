package com.four.d1780.shop.cartAndOrderServer.controller;


import com.four.d1708.shop.entityinterface.entity.ShopOrder;
import com.four.d1780.shop.cartAndOrderServer.service.ShopOrderService;
import com.four.d1780.shop.cartAndOrderServer.service.impl.ShopOrderServiceImpl;
import com.four.d1780.shop.cartAndOrderServer.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wh
 * @since 2020-05-21
 */
@RestController
@RequestMapping("/shop_order")
public class ShopOrderController {

    @Autowired
    ShopOrderService shopOrderService;

    /**
     * 根据用户uid生成订单
     * @param uid
     * @return
     */
    @RequestMapping("/generateOrder")
    public ResultEntity generateOrder(Integer uid,String cids){
        return ResultEntity.ok(shopOrderService.generateOrder(uid,cids));
    }

    /**
     * 查找所有订单
     * @param uid
     * @return
     */
    @RequestMapping("/findAll")
    public ResultEntity findAll(Integer uid){
        return  ResultEntity.ok(shopOrderService.findAll(uid));
    }


    @RequestMapping("/saveOrder")
    public boolean saveOrder(@RequestBody ShopOrder shopOrder){
        return shopOrderService.saveOrder(shopOrder);
    }
}

