package com.four.d1708.shop.userserver.controller;


import com.four.d1708.shop.entityinterface.entity.ShopPay;
import com.four.d1708.shop.entityinterface.entity.ShopUser;
import com.four.d1708.shop.userserver.config.Md5Util;
import com.four.d1708.shop.userserver.entity.ShopUserVo;
import com.four.d1708.shop.userserver.mapper.Shop_payMapper;
import com.four.d1708.shop.userserver.mapper.Shop_userMapper;
import com.four.d1708.shop.userserver.service.IShop_payService;
import com.four.d1708.shop.userserver.service.IShop_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yinshijie
 * @since 2020-05-31
 */
@RestController
@RequestMapping("/shop_user")
@CrossOrigin
public class Shop_userController {


	//代码出来了,但是idea没有,你等一等,我去找找不显示代码的问题
    @Autowired
    private IShop_userService iShop_userService;

    @Autowired
    private IShop_payService iShop_payService;


    @PostMapping("/register")
    public boolean register(@RequestBody ShopUser shop_user){
        String pwd=	Md5Util.string2MD5(shop_user.getPassword());
        shop_user.setPassword(pwd);
        shop_user.setState(0);
        shop_user.setMember_state(0);
        return iShop_userService.save(shop_user);
    }


    @RequestMapping("/login")
    public ShopUser login(@RequestBody ShopUser shop_user){
        String pwd=Md5Util.string2MD5(shop_user.getPassword());
        shop_user.setPassword(pwd);
        System.err.println(shop_user);
        ShopUserVo shopUserVo = iShop_userService.findByNameAndPassword(shop_user.getUsername(), shop_user.getPassword());
        System.out.println(shopUserVo);
        return shopUserVo;
    }


    @RequestMapping("addpay")
    public void addpay(@RequestBody ShopPay shop_pay){
       iShop_payService.save(shop_pay);
    }





  /*  @RequestMapping("/login")
    public Shop_user login(@RequestBody Shop_user  shop_user){
        return (Shop_user) iShop_userService.findByNameAndPassword(shop_user);
    }*/
   /* @RequestMapping("/register")
    public boolean register(@RequestBody Shop_user  shop_user){
        iShop_userService.register(shop_user);
    }*/

}

