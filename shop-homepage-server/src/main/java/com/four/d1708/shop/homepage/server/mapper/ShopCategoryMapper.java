package com.four.d1708.shop.homepage.server.mapper;

import com.four.d1708.shop.entityinterface.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryMapper {

    public List<ShopCategory> findBypid(Integer pid);

    List<ShopCategory> getList();
}
