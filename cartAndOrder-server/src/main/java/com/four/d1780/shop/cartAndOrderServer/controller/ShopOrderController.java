package com.four.d1780.shop.cartAndOrderServer.controller;


import com.four.d1708.shop.entityinterface.entity.ShopOrder;
import com.four.d1780.shop.cartAndOrderServer.service.ShopOrderService;
import com.four.d1780.shop.cartAndOrderServer.service.impl.ShopOrderServiceImpl;
import com.four.d1780.shop.cartAndOrderServer.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wh
 * @since 2020-05-21
 */
@RestController
@RequestMapping("/hypermarket_order")
public class ShopOrderController {

    @Autowired
    ShopOrderService shopOrderService;

    /**
     * 根据用户uid生成订单
     * @param shopOrder
     * @return
     */
    @PostMapping("/generateOrder")
    public ResultEntity generateOrder(@RequestBody ShopOrder shopOrder){

        return ResultEntity.ok(shopOrderService.generateOrder(shopOrder));
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



}

