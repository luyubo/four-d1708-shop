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
        //分页
        Page page=new Page(pageNum,pageSize);
        //查询
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
        //修改用户状态
        return iUserService.updateUserStateByUid(uid,state);
    }

    /*
     * @Author luyubo
     * @Description 修改用户会员状态
     * @Date  2020/5/29 17:34
     * @Param [uid:用户id, member_state:用户会员状态]
     * @return boolean
     **/
    @PostMapping("/updateUserMemberStateByUid")
    public boolean updateUserMemberStateByUid(@RequestParam("uid")Integer uid,
                                              @RequestParam("member_state")Integer member_state){
        //修改用户状态
        return iUserService.updateUserMemberStateByUid(uid,member_state);
    }

    /*
     * @Author luyubo
     * @Description 根据id查询用户
     * @Date  2020/5/29 17:09
     * @Param [uid:用户主键id]
     * @return com.four.d1708.shop.entityinterface.entity.ShopUser
     **/
    @PostMapping("/findUserByUid")
    public ShopUser findUserByUid(@RequestParam("uid")Integer uid){
        //返回查询到的用户
        return iUserService.getById(uid);
    }

    /**
     * @Author luyubo
     * @Description 批量修改用户状态
     * @Date  2020/5/29 18:16
     * @Param [uids:拼接的用户主键id]
     * @return boolean
     **/
    @PostMapping("/updateUserStateByUids")
    public boolean updateUserStateByUids(@RequestParam("uids")String uids){
        //修改状态
        return iUserService.updateUserStateByUids(uids);
    }
}
