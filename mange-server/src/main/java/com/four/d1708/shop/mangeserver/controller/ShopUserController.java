package com.four.d1708.shop.mangeserver.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopUser;
import com.four.d1708.shop.mangeserver.entity.ShopUserVo;
import com.four.d1708.shop.mangeserver.service.IShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyubo
 * @Title: UserController
 * @Package controller
 * @Description: mange的user控制器类
 * @date 2020/5/21/8:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/mangeuser")
public class ShopUserController {

    @Autowired
    private IShopUserService iUserService;

    /*
     * @Author luyubo
     * @Description //用户列表查询
     * @Date  2020/5/21 8:28
     * @Param [pageNum当前页, pageSize每页数据, shopUserVo查询条件]
     * @return java.lang.Object
     **/
    @RequestMapping("/findAll")
    public Object findAll(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                          @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                            ShopUserVo shopUserVo){
        Page page=new Page(pageNum,pageSize);
        return iUserService.findAll(page,shopUserVo);
    }

    /*
     * @Author luyubo
     * @Description //修改用户状态
     * @Date  2020/5/29 11:11
     * @Param [uid:用户id, state:用户状态]
     * @return boolean
     **/
    @PostMapping("/updateUserStateByUid")
    public boolean updateUserStateByUid(@RequestParam("uid")Integer uid,
                                        @RequestParam("state")Integer state){
        return iUserService.updateUserStateByUid(uid,state);
    }
}
