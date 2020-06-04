package com.four.d1780.shop.cartAndOrderServer.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopCartdetail;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopCartDetailVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ShopCartdetailMapper extends BaseMapper<ShopCartdetail> {

    ShopCartdetail fandBySkuId(@Param("cartId") Integer cartId, @Param("skuid")Integer skuid);

    @Delete(" DELETE FROM shop_cartdetail WHERE skuid=#{skuid} AND cartId=#{cartId} ")
    int deleteById2(@Param("cartId")Integer cartId,@Param("skuid")Integer skuid);

    List<ShopCartdetail> findAllByUid(Integer cartId);

    @Update("UPDATE shop_cartdetail a SET a.`amount`=#{amount}   WHERE a.cartId=#{cartId}   AND skuid= #{skid} ")
    int modifiedAmountBySkidAndUid(@Param("skid")Integer skid,@Param("cartId") Integer cartId, @Param("amount")Integer amount);

    List<ShopCartdetail> findAllByCartId(Integer cartId);

    ShopCartDetailVo selectVoById(int id);

    int updateCartDetail(@Param("id") Integer id,@Param("state") Integer stete);
}
