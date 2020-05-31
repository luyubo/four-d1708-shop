package com.four.d1708.shop.mangeserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.entityinterface.entity.ShopCategory;
import com.four.d1708.shop.mangeserver.mapper.CategoryMapper;
import com.four.d1708.shop.mangeserver.service.ICategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, ShopCategory> implements ICategoryService {

}
