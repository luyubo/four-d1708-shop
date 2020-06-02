package com.four.d1780.shop.cartAndOrderServer.service.impl;

import com.four.d1708.shop.entityinterface.entity.ShopAddr;
import com.four.d1708.shop.entityinterface.entity.ShopArea;
import com.four.d1780.shop.cartAndOrderServer.mapper.ShopAreaMapper;
import com.four.d1780.shop.cartAndOrderServer.service.ShopAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopAreaServiceImpl implements ShopAreaService {

    @Autowired
    ShopAreaMapper shopAreaMapper;
    @Override
    public List<ShopArea> list(Integer uid) {
        return shopAreaMapper.list(uid);
    }

    @Override
    public int updateAddrStateByUidAndAddrId(Integer uid, Integer addrId) {
        List<ShopAddr> addrList = shopAreaMapper.findByUidAndAddrId(uid);
        for (ShopAddr sa:addrList) {
            sa.setState(0);
            shopAreaMapper.updateAddrStateByUidAndAddrId2(uid,sa.getId());
        }
        shopAreaMapper.updateAddrStateByUidAndAddrId(uid,addrId);

        return 1;
    }
}
