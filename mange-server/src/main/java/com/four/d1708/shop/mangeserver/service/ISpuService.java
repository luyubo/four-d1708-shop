package com.four.d1708.shop.mangeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.four.d1708.shop.entityinterface.entity.ShopSpu;
import com.four.d1708.shop.mangeserver.entity.ShopSpuVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
public interface ISpuService extends IService<ShopSpu> {

    IPage<ShopSpuVo> findAll(Page page, ShopSpuVo shopSpuVo);
}
