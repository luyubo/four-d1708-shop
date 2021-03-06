package com.four.d1708.shop.userserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopArea;
import com.four.d1708.shop.userserver.entity.ShopAreaVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
public interface AreaMapper extends BaseMapper<ShopArea> {

    List<ShopAreaVo> findAll();
}
