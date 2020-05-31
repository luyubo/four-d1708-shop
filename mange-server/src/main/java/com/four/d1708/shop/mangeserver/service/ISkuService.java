package com.four.d1708.shop.mangeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.four.d1708.shop.entityinterface.entity.ShopSku;
import com.four.d1708.shop.mangeserver.entity.ShopSkuVo;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
public interface ISkuService extends IService<ShopSku> {

    IPage<ShopSkuVo> findAll(Page page, ShopSkuVo shopSkuVo);

    boolean deleteBySkuId(Integer skuId);

    ShopSkuVo findSkuBySkuId(Integer skuId);

    boolean updateSkuStatusByskuIds(String skuIds);
}
