package com.four.d1708.shop.userserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopOrder;
import com.four.d1708.shop.userserver.entity.ShopOrderVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
public interface OrderMapper extends BaseMapper<ShopOrder> {

    List<ShopOrderVo> getByUid(Integer uid);
}
