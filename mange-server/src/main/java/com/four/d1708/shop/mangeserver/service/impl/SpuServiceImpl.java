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

    /**
     * @Author luyubo
     * @Description 查询
     * @Date  2020/5/30 1:33
     * @Param [page:分页条件, shopSpuVo:查询条件]
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.four.d1708.shop.mangeserver.entity.ShopSpuVo>
     **/
    @Override
    public IPage<ShopSpuVo> findAll(Page page, ShopSpuVo shopSpuVo) {
        return spuMapper.findAll(page,shopSpuVo);
    }

    /**
     * @Author luyubo
     * @Description 修改商品状态
     * @Date  2020/5/30 1:35
     * @Param [spuId:spu的id]
     * @return boolean
     **/
    @Override
    public boolean deleteBySpuId(Integer spuId) {
        //1).根据id查询Spu的数据
        ShopSpu shopSpu = spuMapper.selectById(spuId);
        //2).设置Spu的状态
        shopSpu.setIs_marketable("2");
        //3).修改保存
        int i = spuMapper.updateById(shopSpu);
        //4).返回操作
        if(i>0){
            return true;
        }
        return false;
    }

    /**
     * @Author luyubo
     * @Description 根据id查询spu数据
     * @Date  2020/5/31 17:29
     * @Param [spuId:id值]
     * @return com.four.d1708.shop.mangeserver.entity.ShopSpuVo
     **/
    @Override
    public ShopSpuVo findSpuBySpuId(Integer spuId) {
        return spuMapper.findSpuBySpuId(spuId);
    }

    /**
     * @Author luyubo
     * @Description 根据拼接的spuIds查处spu数据,并修改为下架
     * @Date  2020/5/31 17:28
     * @Param [spuIds]
     * @return boolean
     **/
    @Override
    public boolean updateSpuIsMarketableByspuIds(String spuIds) {
        //1).根据,切割SpuIds为数组
        String[] split = spuIds.split(",");
        //2).遍历切割后的数组
        for (String s : split) {
            //3).根据id值查询到spu信息
            ShopSpu shopSpu = spuMapper.selectById(Integer.parseInt(s));
            //4).修改商品状态
            shopSpu.setIs_marketable("2");
            //5).保存修改
            spuMapper.updateById(shopSpu);
        }
        //6).返回
        return true;
    }
}
