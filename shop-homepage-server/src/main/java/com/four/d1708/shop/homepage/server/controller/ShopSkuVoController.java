package com.four.d1708.shop.homepage.server.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopCategory;
import com.four.d1708.shop.homepage.server.entity.ShopSkuVo;
import com.four.d1708.shop.homepage.server.server.ShopCagetoryService;
import com.four.d1708.shop.homepage.server.server.ShopSkuVoService;
import com.four.d1708.shop.entityinterface.entity.ShopSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopsku")
public class ShopSkuVoController {


    @Autowired
    private ShopSkuVoService shopSkuVoService;


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ShopCagetoryService shopCagetoryService;

    @RequestMapping("/list")
    public IPage<ShopSku> list(@RequestParam(defaultValue = "1") Integer current,
                               @RequestParam(defaultValue = "9") Integer size, String title,String cname){
        ShopSkuVo vo = new ShopSkuVo();
        vo.setTitle(title);
        vo.setCname(cname);
        String key="skuList";
        Page<ShopSku> page=new Page<>(current,size);
        ValueOperations<String,IPage<ShopSku>> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,  shopSkuVoService.pageInfo(page, vo));
        if(redisTemplate.hasKey(key)){
            System.out.println("123435");
            System.out.println("--------------"+valueOperations.get(key));
            return  valueOperations.get(key);
        }else {
            System.out.println("67890");
            valueOperations.set(key,  shopSkuVoService.pageInfo(page, vo));
            return shopSkuVoService.pageInfo(page, vo);
        }
    }

    @RequestMapping("/findAll")
    public List<ShopCategory> findAll(Integer id){

        return shopCagetoryService.findBypid(id);
    }
    /*
    * 查询商品分类
    *
    * */
    @RequestMapping("cateList")
    public List<ShopCategory> cateList(){
        return  shopSkuVoService.getList();
    }
    /*
    * 查询商品详情
    * */
    @RequestMapping("/findOne")
    public  ShopSku findOne(Integer id){
        return  shopSkuVoService.findOne(id);
    }
}
