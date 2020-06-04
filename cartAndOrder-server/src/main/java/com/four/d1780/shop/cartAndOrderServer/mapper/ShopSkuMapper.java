package com.four.d1780.shop.cartAndOrderServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopSku;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopSkuVo;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author wh
 * @since 2020-05-21
 */
public interface ShopSkuMapper extends BaseMapper<ShopSku> {

//    @Select("SELECT a.* FROM shop_sku a WHERE a.id=#{skuid}")
    ShopSku fandBySkuId(Integer skuid);

    ShopSkuVo selectSkuById(String skuid);

    ShopSkuVo selectSkuBySkuId(Integer skuid);
}
