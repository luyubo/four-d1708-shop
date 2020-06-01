package com.four.d1708.shop.homepage.server.server.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopCategory;
import com.four.d1708.shop.homepage.server.entity.ShopSkuVo;
import com.four.d1708.shop.homepage.server.mapper.ShopSkuVoMapper;
import com.four.d1708.shop.homepage.server.server.ShopSkuVoService;
import com.four.d1708.shop.entityinterface.entity.ShopSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class ShopSkuVoServiceImpl implements ShopSkuVoService {

        @Autowired
        private ShopSkuVoMapper shopSkuVoMapper;
        @Override
        public IPage pageInfo(Page<ShopSku> page, ShopSkuVo vo) {

            return shopSkuVoMapper.pageInfo(page,vo);
    }

    @Override
    public ShopSku findOne(Integer id) {
        return shopSkuVoMapper.findOne(id);
    }

    @Override
    public List<ShopCategory> getList() {
        return shopSkuVoMapper.getList();
    }

    @Override
    public boolean save(ShopSku entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<ShopSku> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<ShopSku> entityList, int batchSize) {
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
    public boolean remove(Wrapper<ShopSku> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(ShopSku entity) {
        return false;
    }

    @Override
    public boolean update(ShopSku entity, Wrapper<ShopSku> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<ShopSku> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(ShopSku entity) {
        return false;
    }

    @Override
    public ShopSku getById(Serializable id) {
        return null;
    }

    @Override
    public List<ShopSku> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<ShopSku> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public ShopSku getOne(Wrapper<ShopSku> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<ShopSku> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<ShopSku> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count(Wrapper<ShopSku> queryWrapper) {
        return 0;
    }

    @Override
    public List<ShopSku> list(Wrapper<ShopSku> queryWrapper) {
        return null;
    }

    @Override
    public <E extends IPage<ShopSku>> E page(E page, Wrapper<ShopSku> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<ShopSku> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<ShopSku> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<ShopSku> queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper<ShopSku> getBaseMapper() {
        return null;
    }
}
