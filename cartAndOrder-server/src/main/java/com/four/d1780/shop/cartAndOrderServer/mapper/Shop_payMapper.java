package com.four.d1780.shop.cartAndOrderServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopPay;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopPayVo;
import org.apache.ibatis.annotations.Mapper;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yinshijie
 * @since 2020-05-31
 */
@Mapper
public interface Shop_payMapper extends BaseMapper<ShopPay> {

    ShopPayVo findByUid(Integer uid);
}
