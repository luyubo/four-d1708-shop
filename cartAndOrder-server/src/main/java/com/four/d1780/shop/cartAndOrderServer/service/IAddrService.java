package com.four.d1780.shop.cartAndOrderServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.four.d1708.shop.entityinterface.entity.ShopAddr;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopAddrVo;;import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
public interface IAddrService extends IService<ShopAddr> {

    List<ShopAddrVo> findByUid(String uid);
}
