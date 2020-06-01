package com.four.d1780.shop.cartAndOrderServer.service.impl;

import com.four.d1708.shop.entityinterface.entity.*;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopCartVo;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopOrderVo;
import com.four.d1780.shop.cartAndOrderServer.mapper.*;
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

    @Autowired
    ShopCartdetailMapper shopCartdetailMapper;

    @Autowired
    ShopAreaMapper shopAreaMapper;

    @Autowired
    ShopOrderdetaieMapper shopOrderdetaieMapper;

    @Override
    public List<ShopOrderVo> findAll(Integer uid) {
        return shopOrderMapper.findAll(uid);
    }

    @Override
    public int generateOrder(Integer uid) {
        ShopAddr addr = shopAreaMapper.findByUidAndState(uid);
        //查找购物车对象
        ShopCart shopCart = shopCartMapper.findByUid(uid);
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setUid(uid);
        shopOrder.setCreatetime(new Date());
        BigDecimal pnum1 = new BigDecimal(String.valueOf(shopCart.getPnum()));
        shopOrder.setPnum(pnum1.intValue());
        shopOrder.setSum(shopCart.getSum_total());
        shopOrder.setState(0);
        shopOrderMapper.insert(shopOrder);
        Integer oid = shopOrder.getOid();
        List<ShopCartdetail> shopCartdetailList = shopCartdetailMapper.findAllByUid(shopCart.getId());
        for (ShopCartdetail sc:shopCartdetailList ) {
            ShopOrderdetail shopOrderdetail = new ShopOrderdetail();
            shopOrderdetail.setOrder_id(oid);
            shopOrderdetail.setSku_id(sc.getSkuid());
            shopOrderdetail.setTitle(sc.getTitle());
            shopOrderdetail.setPrice(sc.getPrice());
            shopOrderdetail.setStock_count(sc.getStock_count());
            shopOrderdetail.setImage(sc.getImage());
            shopOrderdetail.setState(sc.getState());
            shopOrderdetail.setCreate_time(new Date());
            shopOrderdetail.setSpu_id(sc.getSpu_id());
            shopOrderdetail.setAmount(sc.getAmount());
            shopOrderdetail.setAddr_id(addr.getId());
            shopOrderdetaieMapper.insert(shopOrderdetail);
        }
        return 0;
    }
}
