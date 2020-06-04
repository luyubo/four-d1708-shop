package com.four.d1780.shop.cartAndOrderServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.four.d1708.shop.entityinterface.entity.ShopCart;
import com.four.d1708.shop.entityinterface.entity.ShopSku;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopCartVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wh
 * @since 2020-05-21
 */
public interface ShopCartService extends IService<ShopCart> {

    List<ShopCartVo> findAllByUid(Integer uid);

    int deleteById(Integer skid,Integer uid);

    int deleteByUid(Integer uid);

    int generateOrder(Integer uid);

    int addCart(Integer uid, Integer skuid);

    int modifiedAmountBySkidAndUid(Integer skid, Integer uid,Integer amount,Integer cartId);

    boolean addCartAndDetail(ShopCart shopCart);
}
