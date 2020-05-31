package com.four.d1780.shop.cartAndOrderServer.mapper;

import com.four.d1780.shop.cartAndOrderServer.entity.ShopCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopCartVo;
import org.apache.ibatis.annotations.Delete;

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

    @Delete(" DELETE FROM hypermarket_cart WHERE id=#{id} ")
    int deleteById2(Integer id);
}
