package com.four.d1708.shop.userserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.entityinterface.entity.ShopAddr;
import com.four.d1708.shop.userserver.entity.ShopAddrVo;
import com.four.d1708.shop.userserver.mapper.AddrMapper;
import com.four.d1708.shop.userserver.service.IAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
@Service
public class AddrServiceImpl extends ServiceImpl<AddrMapper, ShopAddr> implements IAddrService {

    @Autowired
    private AddrMapper addrMapper;

    @Override
    public List<ShopAddrVo> findAddrByUid(Integer uid) {
        return addrMapper.findAddrByUid(uid);
    }
}
