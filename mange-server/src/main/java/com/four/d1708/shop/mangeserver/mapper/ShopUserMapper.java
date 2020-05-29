package com.four.d1708.shop.mangeserver.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.mangeserver.entity.ShopUserVo;

/**
 * @author luyubo
 * @Title: ShopUserMapper
 * @Package mapper
 * @Description: 持久层接口
 * @date 2020/5/21/8:08
 * @Version 1.0
 */
public interface ShopUserMapper extends BaseMapper<ShopUser> {

    IPage<ShopUserVo> findAll(Page page, ShopUserVo shopUserVo);
}
