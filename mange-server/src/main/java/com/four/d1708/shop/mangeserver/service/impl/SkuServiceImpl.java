package com.four.d1708.shop.mangeserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.entityinterface.entity.ShopSku;
import com.four.d1708.shop.mangeserver.entity.ShopSkuVo;
import com.four.d1708.shop.mangeserver.mapper.SkuMapper;
import com.four.d1708.shop.mangeserver.service.ISkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, ShopSku> implements ISkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public IPage<ShopSkuVo> findAll(Page page, ShopSkuVo shopSkuVo) {
        return skuMapper.findAll(page,shopSkuVo);
    }

    @Override
    public boolean deleteBySkuId(Integer skuId) {
        //1).根据id查询sku信息
        ShopSku shopSku = skuMapper.selectById(skuId);
        //2).修改查询到的sku数据
        shopSku.setStatus("3");
        //3).保存修改
        int i = skuMapper.updateById(shopSku);
        //4).返回状态
        if(i>0){
            return true;
        }
        return false;
    }

    /**
     * @Author luyubo
     * @Description 根据sku的id查询sku的数据,做修改用
     * @Date  2020/5/31 20:11
     * @Param [skuId:sku的id]
     * @return com.four.d1708.shop.mangeserver.entity.ShopSkuVo
     **/
    @Override
    public ShopSkuVo findSkuBySkuId(Integer skuId) {
        return skuMapper.findSkuBySkuId(skuId);
    }

    /**
     * @Author luyubo
     * @Description 根据拼接的skuid做删除sku的操作
     * @Date  2020/5/31 20:12
     * @Param [skuIds:sku的id拼接]
     * @return boolean
     **/
    @Override
    public boolean updateSkuStatusByskuIds(String skuIds) {
        //1).根据,做切割
        String[] split = skuIds.split(",");
        //2).遍历数组
        for (String s : split) {
            //3).根据遍历的id查询sku的数据
            ShopSku shopSku = skuMapper.selectById(Integer.parseInt(s));
            //4).修改sku的状态为删除
            shopSku.setStatus("3");
            //5).保存修改
            skuMapper.updateById(shopSku);
        }
        //6).返回值
        return true;
    }
}
