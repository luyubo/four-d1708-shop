package com.four.d1708.shop.mangeserver.controller;

import com.four.d1708.shop.entityinterface.entity.ShopCategory;
import com.four.d1708.shop.mangeserver.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luyubo
 * @Title: ShopCategoryController
 * @Package controller
 * @Description: 分类查询
 * @date 2020/5/30/0:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/mangecategory")
public class ShopCategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping("/findAll")
    public List<ShopCategory> findAll(){
        return iCategoryService.list();
    }
}
