package com.four.d1780.shop.cartAndOrderServer.controller;


import com.four.d1708.shop.entityinterface.entity.ShopCart;
import com.four.d1708.shop.entityinterface.entity.ShopSku;
import com.four.d1780.shop.cartAndOrderServer.service.ShopCartService;
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
@RequestMapping("/shop_cart")
public class ShopCartController {

    @Autowired
    ShopCartService shopCartService;

    /**
     * 添加购物车
     * @param uid
     * @param skuid
     * @return
     */
    @RequestMapping("/addCart")
    public ResultEntity addCart(Integer uid,Integer skuid){
        int i = shopCartService.addCart(uid, skuid);
        return  ResultEntity.ok("uid用户"+uid+",商品id为"+skuid+",添加购物车成功");
    }

    @PostMapping("/addCartAndDetail")
    public boolean addCartAndDetail(@RequestBody ShopCart shopCart){
        return shopCartService.addCartAndDetail(shopCart);
    }

    /**
     * 根据用户id查找对应的购物车明细 列表功能
     * @param uid
     * @return
     */
    @RequestMapping("/findAllByUid")
    public ResultEntity findAll(@RequestParam("uid") Integer uid){
        return  ResultEntity.ok(shopCartService.findAllByUid(uid));
    }


    /**
     * 删除购物车的单个数据
     * @param skid
     * @return
     */
    @RequestMapping("/deleteById")
    public ResultEntity deleteById(@RequestParam("skid") Integer skid,@RequestParam("uid") Integer uid){
        System.err.println(skid+"|"+uid);
        return  ResultEntity.ok(shopCartService.deleteById(skid,uid));
    }

    /**
     * 修改商品个数
     * @param skid
     * @param uid
     * @param amount
     * @return
     */
    @RequestMapping("/modifiedAmountBySkidAndUid")
    public ResultEntity modifiedAmountBySkidAndUid(Integer skid,Integer uid,Integer amount,Integer cartId){
        return  ResultEntity.ok(shopCartService.modifiedAmountBySkidAndUid(skid,uid,amount,cartId));
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

