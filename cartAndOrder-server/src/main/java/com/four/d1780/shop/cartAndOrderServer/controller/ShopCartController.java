package com.four.d1780.shop.cartAndOrderServer.controller;


import com.four.d1780.shop.cartAndOrderServer.service.ShopCartService;
import com.four.d1780.shop.cartAndOrderServer.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/hypermarket_cart")
public class ShopCartController {

    @Autowired
    ShopCartService shopCartService;

    /**
     * 根据用户id查找对应的购物车明细
     * @param uid
     * @return
     */
    @RequestMapping("/findAllByUid")
    public ResultEntity findAll(Integer uid){
        return  ResultEntity.ok(shopCartService.findAllByUid(uid));
    }


    /**
     * 删除购物车的单个数据
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public ResultEntity deleteById(Integer id){
        return  ResultEntity.ok(shopCartService.deleteById(id));
    }

    /**
     * 根据用户uid删除购物车
     * @param uid
     * @return
     */
    @RequestMapping("/deleteByUid")
    public ResultEntity deleteByUid(Integer uid){
        return  ResultEntity.ok(shopCartService.deleteByUid(uid));
    }



}

