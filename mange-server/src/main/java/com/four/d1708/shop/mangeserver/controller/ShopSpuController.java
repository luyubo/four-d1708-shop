package com.four.d1708.shop.mangeserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.mangeserver.entity.ShopSpuVo;
import com.four.d1708.shop.mangeserver.service.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
