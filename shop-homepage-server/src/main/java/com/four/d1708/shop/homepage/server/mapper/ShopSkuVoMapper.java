package com.four.d1708.shop.homepage.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopCategory;
import com.four.d1708.shop.homepage.server.entity.ShopSkuVo;
import com.four.d1708.shop.entityinterface.entity.ShopSku;

import java.util.List;

public interface ShopSkuVoMapper {

    IPage pageInfo(Page<ShopSku> page, ShopSkuVo vo);

    ShopSku findOne(Integer id);
    List<ShopCategory> getList();
}
