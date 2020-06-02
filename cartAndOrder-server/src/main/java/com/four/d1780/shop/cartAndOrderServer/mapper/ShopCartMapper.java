package com.four.d1780.shop.cartAndOrderServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopCart;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopCartVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wh
 * @since 2020-05-21
 */
public interface ShopCartMapper extends BaseMapper<ShopCart> {

    List<ShopCartVo> findAllByUid(Integer uid);

    @Select("SELECT a.* FROM shop_cart a WHERE a.uid=#{uid}")
    ShopCart findByUid(Integer uid);

    ShopCart selectByUid(Integer uid);

    ShopCart findPnumAndSumTotalByCaridAndSkuId(@Param("cartId") Integer cartId, @Param("skuid")Integer skuid);

    @Update("UPDATE shop_cartdetail a SET a.amount=a.amount+1,a.`update_time`=NOW()  WHERE a.cartId=#{cartId} AND a.skuid=#{skuid}")
    int updateByCartIdAndSkuId(@Param("cartId") Integer cartId, @Param("skuid")Integer skuid);


}
