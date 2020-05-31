package com.four.d1780.shop.cartAndOrderServer.service.impl;

import com.four.d1708.shop.entityinterface.entity.ShopOrder;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopCartVo;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopOrderVo;
import com.four.d1780.shop.cartAndOrderServer.mapper.ShopCartMapper;
import com.four.d1780.shop.cartAndOrderServer.mapper.ShopOrderMapper;
import com.four.d1780.shop.cartAndOrderServer.service.ShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

    @Autowired
    ShopOrderMapper shopOrderMapper;

    @Autowired
    ShopCartMapper shopCartMapper;

    @Override
    public List<ShopOrderVo> findAll(Integer uid) {
        return shopOrderMapper.findAll(uid);
    }

    @Override
    public int generateOrder(ShopOrder shopOrder) {
        //形参中有 省市县id 详细地址 用户主键uid
        //查找购物车表
        List<ShopCartVo> all = shopCartMapper.findAllByUid(shopOrder.getUid());
        for (ShopCartVo cart:all) {
            //创建订单对象(订单表为订单详情表)
            ShopOrder order = new ShopOrder();
            order.setUid(shopOrder.getUid());
            order.setAddress(shopOrder.getAddress());
            order.setCreatetime(new Date());
            order.setSkuid(cart.getSkid());
            order.setPnum(cart.getPnum());
            BigDecimal price = cart.getPrice();
            int pnum = cart.getPnum();
            BigDecimal sum = price.multiply(BigDecimal.valueOf(pnum));
//            BigDecimal pnum1 = new BigDecimal(pnum);
//            int i = pnum1 * price;
            order.setSum(sum);
//            order.setProvinceId(shopOrder.getProvinceId());
//            order.setCityId(shopOrder.getCityId());
//            order.setCountryId(shopOrder.getCountryId());
//            shopOrderMapper.insert(order);
        }
        return 0;
    }
}
