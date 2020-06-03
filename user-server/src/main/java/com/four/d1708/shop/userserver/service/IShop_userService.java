package com.four.d1708.shop.userserver.service;

import com.four.d1708.shop.entityinterface.entity.ShopUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.four.d1708.shop.userserver.entity.ShopUserVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yinshijie
 * @since 2020-05-31
 */
public interface IShop_userService extends IService<ShopUser> {
    ShopUserVo findByNameAndPassword(String name, String password);

    boolean toMange(ShopUser shopUser);


    // List<Shop_user> findByNameAndPassword(Shop_user shop_user);

   // void register(Shop_user shop_user);


}
