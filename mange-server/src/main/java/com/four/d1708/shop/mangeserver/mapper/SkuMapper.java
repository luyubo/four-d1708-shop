package com.four.d1708.shop.mangeserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopSku;
import com.four.d1708.shop.mangeserver.entity.ShopSkuVo;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
public interface SkuMapper extends BaseMapper<ShopSku> {

    IPage<ShopSkuVo> findAll(Page page, ShopSkuVo shopSkuVo);

    ShopSkuVo findSkuBySkuId(Integer skuId);
}
