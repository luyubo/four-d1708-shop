package com.four.d1708.shop.mangeserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopSpu;
import com.four.d1708.shop.mangeserver.entity.ShopSpuVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
public interface SpuMapper extends BaseMapper<ShopSpu> {

    IPage<ShopSpuVo> findAll(Page page, ShopSpuVo shopSpuVo);
}
