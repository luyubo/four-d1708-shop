package com.four.d1708.shop.homepage.server.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.four.d1708.shop.entityinterface.entity.ShopCategory;
import com.four.d1708.shop.entityinterface.entity.ShopSku;

import java.util.List;

public interface ShopCagetoryService extends IService<ShopCategory> {

    public List<ShopCategory> findBypid(Integer pid);

    List<ShopCategory> getlist();
}
