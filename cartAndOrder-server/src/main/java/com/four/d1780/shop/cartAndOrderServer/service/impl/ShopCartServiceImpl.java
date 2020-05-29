package com.four.d1780.shop.cartAndOrderServer.service.impl;

import com.four.d1780.shop.cartAndOrderServer.entity.ShopCart;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopCartVo;
import com.four.d1780.shop.cartAndOrderServer.mapper.ShopCartMapper;
import com.four.d1780.shop.cartAndOrderServer.service.ShopCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wh
 * @since 2020-05-21
 */
@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartMapper, ShopCart> implements ShopCartService {

    @Autowired
    ShopCartMapper shopCartMapper;
    //查找购物车列表
    @Override
    public List<ShopCartVo> findAllByUid(Integer uid) {
        return shopCartMapper.findAllByUid(uid);
    }

    //删除购物车的某件商品
    @Override
    public int deleteById(Integer id) {
        return shopCartMapper.deleteById2(id);
    }

    //删除购物车  先查再删
    @Override
    public int deleteByUid(Integer uid) {
        List<ShopCartVo> allByUid = shopCartMapper.findAllByUid(uid);
        for (ShopCart sc:allByUid ) {
            shopCartMapper.deleteById2(sc.getId());
        }
        return 1;
    }

    /**
     * 根据uid生成订单
     * @param uid
     * @return
     */
    @Override
    public int generateOrder(Integer uid) {
        return 0;
    }
}
