package com.four.d1780.shop.cartAndOrderServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopAddr;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopAddrVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
public interface AddrMapper extends BaseMapper<ShopAddr> {

    List<ShopAddrVo> getByUid(Integer uid);
}
