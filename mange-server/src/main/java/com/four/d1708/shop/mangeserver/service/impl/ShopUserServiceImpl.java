package com.four.d1708.shop.mangeserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.mangeserver.entity.ShopUserVo;
import com.four.d1708.shop.mangeserver.mapper.ShopUserMapper;
import com.four.d1708.shop.mangeserver.service.IShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luyubo
 * @Title: ShopUserServiceImpl
 * @Package impl
 * @Description: 业务逻辑层
 * @date 2020/5/21/8:08
 * @Version 1.0
 */
@Service
public class ShopUserServiceImpl extends ServiceImpl<ShopUserMapper, ShopUser> implements IShopUserService {
    @Autowired
    private ShopUserMapper shopUserMapper;
    /*
     * @Author luyubo
     * @Description //用户列表分页
     * @Date  2020/5/21 23:31
     * @Param [page:分页条件, shopUserVo:查询条件]
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.four.d1708.shop.mangeserver.entity.ShopUserVo>
     **/
    @Override
    public IPage<ShopUserVo> findAll(Page page, ShopUserVo shopUserVo) {
        return shopUserMapper.findAll(page,shopUserVo);
    }

    /*
     * @Author luyubo
     * @Description //修改状态
     * @Date  2020/5/29 11:12
     * @Param [uid:用户id, state:用户状态]
     * @return boolean
     **/
    @Override
    public boolean updateUserStateByUid(Integer uid, Integer state) {
        ShopUser shopUser = shopUserMapper.selectById(uid);
        shopUser.setState(state);
        int i = shopUserMapper.updateById(shopUser);
        if(i>0){
            return true;
        }
        return false;
    }
}
