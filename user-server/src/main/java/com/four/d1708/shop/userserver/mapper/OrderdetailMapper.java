package com.four.d1708.shop.userserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopOrderdetail;
import com.four.d1708.shop.userserver.entity.ShopOrderdetailVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
public interface OrderdetailMapper extends BaseMapper<ShopOrderdetail> {

    ShopOrderdetailVo findByOrderId(Integer oid);
}
