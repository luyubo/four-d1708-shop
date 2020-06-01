package com.four.d1708.shop.homepage.server.server.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.four.d1708.shop.entityinterface.entity.ShopCategory;
import com.four.d1708.shop.homepage.server.mapper.ShopCategoryMapper;
import com.four.d1708.shop.homepage.server.server.ShopCagetoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class ShopCagetoryServiceImpl implements ShopCagetoryService {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;
    @Override
    public boolean save(ShopCategory entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<ShopCategory> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<ShopCategory> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<ShopCategory> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(ShopCategory entity) {
        return false;
    }

    @Override
    public boolean update(ShopCategory entity, Wrapper<ShopCategory> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<ShopCategory> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(ShopCategory entity) {
        return false;
    }

    @Override
    public ShopCategory getById(Serializable id) {
        return null;
    }

    @Override
    public List<ShopCategory> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<ShopCategory> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public ShopCategory getOne(Wrapper<ShopCategory> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<ShopCategory> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<ShopCategory> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count(Wrapper<ShopCategory> queryWrapper) {
        return 0;
    }

    @Override
    public List<ShopCategory> list(Wrapper<ShopCategory> queryWrapper) {
        return null;
    }

    @Override
    public <E extends IPage<ShopCategory>> E page(E page, Wrapper<ShopCategory> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<ShopCategory> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<ShopCategory> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<ShopCategory> queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper<ShopCategory> getBaseMapper() {
        return null;
    }
    /*
    * 根据pid查询
    *
    * */
    @Override
    public List<ShopCategory> findBypid(Integer pid) {
        return shopCategoryMapper.findBypid(pid);
    }

    @Override
    public List<ShopCategory> getlist() {
        return shopCategoryMapper.getList();
    }
}
