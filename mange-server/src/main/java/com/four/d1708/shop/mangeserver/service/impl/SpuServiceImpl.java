package com.four.d1708.shop.mangeserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.entityinterface.entity.ShopSpu;
import com.four.d1708.shop.mangeserver.entity.ShopSpuVo;
import com.four.d1708.shop.mangeserver.mapper.SpuMapper;
import com.four.d1708.shop.mangeserver.service.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SpuServiceImpl extends ServiceImpl<SpuMapper, ShopSpu> implements ISpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public IPage<ShopSpuVo> findAll(Page page, ShopSpuVo shopSpuVo) {
        return spuMapper.findAll(page,shopSpuVo);
    }
}
