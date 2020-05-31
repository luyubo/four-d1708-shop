package com.four.d1708.shop.mangeserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopSpu;
import com.four.d1708.shop.mangeserver.entity.ShopSpuVo;
import com.four.d1708.shop.mangeserver.service.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luyubo
 * @Title: ShopSpuController
 * @Package controller
 * @Description: spu的控制器
 * @date 2020/5/29/18:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/mangespu")
public class ShopSpuController {
    @Autowired
    private ISpuService iSpuService;

    /**
     * @Author luyubo
     * @Description 商品spu分页查询
     * @Date  2020/5/29 23:26
     * @Param [pageNum:当前页, pageSize:每页分页几条, shopSpuVo:条件查询]
     * @return java.lang.Object
     **/
    @RequestMapping("/findAll")
    public Object findAll(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                          @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                          ShopSpuVo shopSpuVo){
        //分页
        Page page=new Page(pageNum,pageSize);
        //查询
        return iSpuService.findAll(page,shopSpuVo);
    }

    /**
     * @Author luyubo
     * @Description //根据spuid修改商品状态
     * @Date  2020/5/30 1:37
     * @Param [spuId:spu的id]
     * @return boolean
     **/
    @PostMapping("/deleteBySpuId")
    public boolean deleteBySpuId(@RequestParam("spuId")Integer spuId){
        return iSpuService.deleteBySpuId(spuId);
    }

    /**
     * @Author luyubo
     * @Description 保存spu
     * @Date  2020/5/31 17:05
     * @Param [shopSpu:保存的信息]
     * @return boolean
     **/
    @PostMapping("/saveSpu")
    public boolean saveSpu(@RequestBody ShopSpu shopSpu){
        //返回保存结果
         return iSpuService.save(shopSpu);
    }

    /**
     * @Author luyubo
     * @Description 根据id查询spu信息
     * @Date  2020/5/30 2:04
     * @Param [spuId:spu的id]
     * @return com.four.d1708.shop.entityinterface.entity.ShopSpu
     **/
    @PostMapping("/findSpuBySpuId")
    public ShopSpuVo findSpuBySpuId(@RequestParam("spuId")Integer spuId){
        //查询spu数据
        ShopSpuVo spuBySpuId = iSpuService.findSpuBySpuId(spuId);
        //返回spu数据
        return spuBySpuId;
    }

    //上面的findSpuBySpuId和下面的editSpuBySpuId是合用的,用来做修改

    /**
     * @Author luyubo
     * @Description 根据SpuId查询到的数据修改
     * @Date  2020/5/31 17:10
     * @Param [shopSpu:传过来的Spu修改值]
     * @return boolean
     **/
    @PostMapping("/editSpuBySpuId")
    public boolean editSpuBySpuId(@RequestBody ShopSpu shopSpu){
        //修改
        return iSpuService.updateById(shopSpu);
    }

    /**
     * @Author luyubo
     * @Description 多选修改商品下架
     * @Date  2020/5/31 17:23
     * @Param [spuIds:多选拼接的商品id值]
     * @return boolean
     **/
    @PostMapping("/updateSpuIsMarketableByspuIds")
    public boolean updateSpuIsMarketableByspuIds(@RequestParam("spuIds")String spuIds){
        //多选下架
        return iSpuService.updateSpuIsMarketableByspuIds(spuIds);
    }
}
