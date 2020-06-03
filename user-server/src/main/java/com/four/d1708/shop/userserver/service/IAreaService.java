package com.four.d1708.shop.userserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.four.d1708.shop.entityinterface.entity.ShopArea;
import com.four.d1708.shop.userserver.entity.ShopAreaVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
public interface IAreaService extends IService<ShopArea> {

    List<ShopAreaVo> findAllByAra();
}
