package com.four.d1708.shop.userserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.entityinterface.entity.ShopOrderdetail;
import com.four.d1708.shop.userserver.entity.ShopOrderVo;
import com.four.d1708.shop.userserver.entity.ShopOrderdetailVo;
import com.four.d1708.shop.userserver.mapper.OrderMapper;
import com.four.d1708.shop.userserver.mapper.OrderdetailMapper;
import com.four.d1708.shop.userserver.service.IOrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class OrderdetailServiceImpl extends ServiceImpl<OrderdetailMapper, ShopOrderdetail> implements IOrderdetailService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public List<ShopOrderdetail> findOrderDetailByUid(Integer uid) {
        List<ShopOrderVo> byUid = orderMapper.getByUid(uid);
        List<ShopOrderdetail> orderdetailVoList=new ArrayList<>();
        List<Integer> ints=new ArrayList<>();
        for (ShopOrderVo shopOrderVo : byUid) {
            ints.add(shopOrderVo.getOid());
        }
        orderdetailVoList= orderdetailMapper.selectBatchIds(ints);

        for (ShopOrderdetail shopOrderdetailVo : orderdetailVoList) {
            System.out.println(shopOrderdetailVo.getTitle());
        }
        return orderdetailVoList;
    }
}
