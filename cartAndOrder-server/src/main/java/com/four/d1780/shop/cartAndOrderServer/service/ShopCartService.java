package com.four.d1780.shop.cartAndOrderServer.service;

import com.four.d1780.shop.cartAndOrderServer.entity.ShopCart;
import com.baomidou.mybatisplus.extension.service.IService;
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

    int deleteById(Integer id);

    int deleteByUid(Integer uid);

    int generateOrder(Integer uid);
}
