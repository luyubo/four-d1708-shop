package com.four.d1708.shop.userserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.entityinterface.entity.ShopArea;
import com.four.d1708.shop.userserver.entity.ShopAreaVo;
import com.four.d1708.shop.userserver.mapper.AreaMapper;
import com.four.d1708.shop.userserver.service.IAreaService;
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
public class AreaServiceImpl extends ServiceImpl<AreaMapper, ShopArea> implements IAreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<ShopAreaVo> findAllByAra() {
        return areaMapper.findAll();
    }
}
