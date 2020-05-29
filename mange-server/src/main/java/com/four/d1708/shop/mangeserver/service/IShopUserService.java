package com.four.d1708.shop.mangeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.four.d1708.shop.mangeserver.entity.ShopUserVo;

/**
 * @author luyubo
 * @Title: ISHopUserService
 * @Package service
 * @Description: 业务逻辑层接口
 * @date 2020/5/21/8:08
 * @Version 1.0
 */
public interface IShopUserService extends IService<ShopUser> {

    IPage<ShopUserVo> findAll(Page page, ShopUserVo shopUserVo);

    boolean updateUserStateByUid(Integer uid, Integer state);

    boolean updateUserMemberStateByUid(Integer uid, Integer member_state);

    boolean updateUserStateByUids(String uids);
}
