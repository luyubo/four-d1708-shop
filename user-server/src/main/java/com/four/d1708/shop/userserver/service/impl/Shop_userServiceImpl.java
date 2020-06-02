package com.four.d1708.shop.userserver.service.impl;

import com.four.d1708.shop.entityinterface.entity.ShopUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.userserver.entity.ShopUserVo;
import com.four.d1708.shop.userserver.mapper.Shop_userMapper;
import com.four.d1708.shop.userserver.service.IShop_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yinshijie
 * @since 2020-05-31
 */
@Service
public class Shop_userServiceImpl extends ServiceImpl<Shop_userMapper, ShopUser> implements IShop_userService {
    @Autowired
    private Shop_userMapper shop_userMapper;
    @Override
    public ShopUserVo findByNameAndPassword(String name, String password) {
        return shop_userMapper.findByNameAndPassword(name,password);
    }

/*    @Resource
    Shop_userMapper shop_userMapper;



    @Override
    public List<Shop_user> findByNameAndPassword(Shop_user shop_user) {
        List<Shop_user> users = shop_userMapper.findByNameAndPassword(shop_user.getName(), shop_user.getPassword());
        if (users.size()==1){
            return (List<Shop_user>) users.get(0);
        }
        return null;
    }

    @Override
    public void register(Shop_user shop_user) {

        shop_userMapper.register(shop_user);
    }*/


}
