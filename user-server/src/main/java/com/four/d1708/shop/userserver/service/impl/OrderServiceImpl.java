package com.four.d1708.shop.userserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.entityinterface.entity.ShopOrder;
import com.four.d1708.shop.userserver.mapper.OrderMapper;
import com.four.d1708.shop.userserver.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, ShopOrder> implements IOrderService {

}
