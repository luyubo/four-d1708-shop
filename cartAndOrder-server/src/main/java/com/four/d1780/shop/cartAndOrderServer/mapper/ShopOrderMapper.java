package com.four.d1780.shop.cartAndOrderServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopOrder;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopOrderVo;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopSku;

import java.util.Date;
import java.util.List;

public interface ShopOrderMapper extends BaseMapper<ShopOrder> {
    List<ShopOrderVo> findAll(Integer uid);

    int updateByCreateTime(Date date);
}
