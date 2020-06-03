package com.four.d1708.shop.userserver.controller;


import com.four.d1708.shop.entityinterface.entity.*;
import com.four.d1708.shop.userserver.config.Md5Util;
import com.four.d1708.shop.userserver.entity.*;
import com.four.d1708.shop.userserver.mapper.Shop_payMapper;
import com.four.d1708.shop.userserver.mapper.Shop_userMapper;
import com.four.d1708.shop.userserver.service.*;
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
    @Autowired
    private IShop_userService iShop_userService;

    @Autowired
    private IShop_payService iShop_payService;

    @Autowired
    private IAddrService iAddrService;

    @Autowired
    private IAreaService iAreaService;

    @Autowired
    private IOrderdetailService iOrderdetailService;


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
        ShopUserVo shopUserVo = iShop_userService.findByNameAndPassword(shop_user.getUsername(), shop_user.getPassword());
        return shopUserVo;
    }

    @PostMapping("/toMange")
    public boolean toMange(@RequestBody ShopUser shopUser){
        String pwd=Md5Util.string2MD5(shopUser.getPassword());
        shopUser.setPassword(pwd);
        return iShop_userService.toMange(shopUser);
    }

    @PostMapping("/updateUser")
    public ShopUserVo updateUser(@RequestBody ShopUser shopUser){
        boolean b = iShop_userService.updateById(shopUser);
        if(b){
            return iShop_userService.findByNameAndPassword(shopUser.getUsername(),shopUser.getPassword());
        }
        return null;
    }

    @RequestMapping("addpay")
    public void addpay(@RequestBody ShopPay shop_pay){
       iShop_payService.save(shop_pay);
    }

    @PostMapping("/findAddrByUid")
    public List<ShopAddrVo> findAddrByUid(@RequestParam("uid")Integer uid){
        return iAddrService.findAddrByUid(uid);
    }

    @RequestMapping("/findAllByArea")
    public List<ShopAreaVo> findAllByArea(){
        return iAreaService.findAllByAra();
    }

    @PostMapping("/addAddr")
    public boolean addAddr(@RequestBody ShopAddr shopAddr){
        ShopArea byId1 = iAreaService.getById(shopAddr.getProvince_id());
        ShopArea byId2 = iAreaService.getById(shopAddr.getCity_id());
        ShopArea byId3 = iAreaService.getById(shopAddr.getCountry_id());
        shopAddr.setAddress(byId1.getName()+byId2.getName()+byId3.getName()+shopAddr.getAddress());
        shopAddr.setState(0);
        return iAddrService.save(shopAddr);
    }

    @PostMapping("/editAddr")
    public boolean editAddr(@RequestBody ShopAddr shopAddr){
        ShopArea byId1 = iAreaService.getById(shopAddr.getProvince_id());
        ShopArea byId2 = iAreaService.getById(shopAddr.getCity_id());
        ShopArea byId3 = iAreaService.getById(shopAddr.getCountry_id());
        shopAddr.setAddress(byId1.getName()+byId2.getName()+byId3.getName()+shopAddr.getAddress());
        return iAddrService.updateById(shopAddr);
    }

    @PostMapping("/indexAddr")
    public boolean indexAddr(@RequestParam("id")Integer id,@RequestParam("uid")Integer uid){
        List<ShopAddrVo> addrByUid = iAddrService.findAddrByUid(uid);
        for (ShopAddrVo shopAddrVo : addrByUid) {
            shopAddrVo.setState(0);
            iAddrService.updateById(shopAddrVo);
            if(shopAddrVo.getId()==id) {
                shopAddrVo.setState(1);
                iAddrService.updateById(shopAddrVo);
            }
        }
        return true;
    }

    @PostMapping("/del")
    public boolean del(@RequestParam("id")Integer id){
        ShopAddr byId = iAddrService.getById(id);
        byId.setState(2);
        return iAddrService.updateById(byId);
    }

    @PostMapping("/findPayByUid")
    public ShopPayVo findPay(@RequestParam("uid")Integer uid){
        return iShop_payService.findPayByUid(uid);
    }

    @PostMapping("/savePay")
    public boolean savePay(@RequestBody ShopPay shopPay){
        shopPay.setState("1");
        Md5Util.string2MD5(shopPay.getPassword());
        return iShop_payService.save(shopPay);
    }

    @PostMapping("/getPay")
    public ShopPayVo getPay(@RequestBody ShopPay shopPay){
        String s = Md5Util.string2MD5(shopPay.getPassword());
        shopPay.setPassword(s);
        return iShop_payService.getPayByAmountNumAndPassword(shopPay.getAccount_num(),shopPay.getPassword());
    }

    @PostMapping("/getMoney")
    public boolean getMoney(@RequestBody ShopPay shopPay){
        ShopPay byId = iShop_payService.getById(shopPay.getId());
        byId.setMoney(byId.getMoney().subtract(shopPay.getMoney()));
        return iShop_payService.updateById(byId);
    }

    @PostMapping("/setMoney")
    public boolean setMoney(@RequestBody ShopPay shopPay){
        ShopPay byId = iShop_payService.getById(shopPay.getId());
        byId.setMoney(byId.getMoney().add(shopPay.getMoney()));
        return iShop_payService.updateById(byId);
    }

    @PostMapping("/findOrderDetailByUid")
    public List<ShopOrderdetail> findOrderDetailByUid(@RequestParam("uid")Integer uid){
        return iOrderdetailService.findOrderDetailByUid(uid);
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

