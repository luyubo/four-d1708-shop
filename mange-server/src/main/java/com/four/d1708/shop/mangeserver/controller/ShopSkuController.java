package com.four.d1708.shop.mangeserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopSku;
import com.four.d1708.shop.mangeserver.entity.ShopSkuVo;
import com.four.d1708.shop.mangeserver.service.ISkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luyubo
 * @Title: ShopSkuController
 * @Package controller
 * @Description: sku表的操作
 * @date 2020/5/31/18:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/mangesku")
public class ShopSkuController {
    @Autowired
    private ISkuService iSkuService;

    /**
     * @Author luyubo
     * @Description 根据具体的spuId查询出spu的所有sku数据,并做分页查询
     * @Date  2020/5/31 19:26
     * @Param [pageNum:当前页, pageSize:每页条数, shopSkuVo:spuId值的查询]
     * @return java.lang.Object
     **/
    @RequestMapping("/findAll")
    public Object findAll(@RequestParam("pageNum")Integer pageNum,
                          @RequestParam("pageSize")Integer pageSize,
                          ShopSkuVo shopSkuVo){
        Page page=new Page(pageNum,pageSize);
        return iSkuService.findAll(page,shopSkuVo);
    }

    /**
     * @Author luyubo
     * @Description sku数据的新增
     * @Date  2020/5/31 18:08
     * @Param [shopSku:sku数据]
     * @return boolean
     **/
    @PostMapping("/saveSku")
    public boolean saveSku(@RequestBody ShopSku shopSku){
        return iSkuService.save(shopSku);
    }

    /**
     * @Author luyubo
     * @Description 根据skuId修改sku状态
     * @Date  2020/5/31 18:45
     * @Param [skuId:sku的id]
     * @return boolean
     **/
    @PostMapping("/deleteBySkuId")
    public boolean deleteBySkuId(@RequestParam("skuId")Integer skuId){
        //修改状态
        return iSkuService.deleteBySkuId(skuId);
    }

    /**
     * @Author luyubo
     * @Description 根据skuId做查询
     * @Date  2020/5/31 19:02
     * @Param [skuId:sku的id]
     * @return com.four.d1708.shop.entityinterface.entity.ShopSku
     **/
    @PostMapping("/findSkuBySkuId")
    public ShopSkuVo findSkuBySkuId(@RequestParam("skuId")Integer skuId){
        //根据id查询
        return iSkuService.findSkuBySkuId(skuId);
    }

    //上下组合做根据sku的id做修改功能

    /**
     * @Author luyubo
     * @Description 修改sku数据
     * @Date  2020/5/31 19:25
     * @Param [shopSku:传过来的sku数据]
     * @return boolean
     **/
    @PostMapping("/editSkuBySkuId")
    public boolean editSkuBySkuId(@RequestBody ShopSku shopSku){
        //修改sku数据
        return iSkuService.updateById(shopSku);
    }

    /**
     * @Author luyubo
     * @Description 根据拼接的skuIds做删除sku状态
     * @Date  2020/5/31 20:15
     * @Param [skuIds:拼接的sku状态]
     * @return boolean
     **/
    @PostMapping("/updateSkuStatusByskuIds")
    public boolean updateSkuStatusByskuIds(@RequestParam("skuIds")String skuIds){
        //删除sku(根据id把sku做修改)
        return iSkuService.updateSkuStatusByskuIds(skuIds);
    }
}
