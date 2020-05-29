package com.four.d1708.shop.mangeserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.four.d1708.shop.entityinterface.entity.ShopUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.four.d1708.shop.mangeserver.entity.ShopUserVo;
import com.four.d1708.shop.mangeserver.mapper.ShopUserMapper;
import com.four.d1708.shop.mangeserver.service.IShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luyubo
 * @Title: ShopUserServiceImpl
 * @Package impl
 * @Description: 业务逻辑层
 * @date 2020/5/21/8:08
 * @Version 1.0
 */
@Service
public class ShopUserServiceImpl extends ServiceImpl<ShopUserMapper, ShopUser> implements IShopUserService {
    @Autowired
    private ShopUserMapper shopUserMapper;
    /*
     * @Author luyubo
     * @Description //用户列表分页
     * @Date  2020/5/21 23:31
     * @Param [page:分页条件, shopUserVo:查询条件]
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.four.d1708.shop.mangeserver.entity.ShopUserVo>
     **/
    @Override
    public IPage<ShopUserVo> findAll(Page page, ShopUserVo shopUserVo) {
        return shopUserMapper.findAll(page,shopUserVo);
    }

    /*
     * @Author luyubo
     * @Description //修改状态
     * @Date  2020/5/29 11:12
     * @Param [uid:用户id, state:用户状态]
     * @return boolean
     **/
    @Override
    public boolean updateUserStateByUid(Integer uid, Integer state) {
        //1).根据用户主键id查询用户所有信息
        ShopUser shopUser = shopUserMapper.selectById(uid);
        //2).修改用户的状态
        shopUser.setState(state);
        //3).保存修改
        int i = shopUserMapper.updateById(shopUser);
        //4).判断并返回值
        if(i>0){
            return true;
        }
        return false;
    }

    /**
     * @Author luyubo
     * @Description 修改用户的会员状态
     * @Date  2020/5/29 17:37
     * @Param [uid:用户主键id, member_state:会员状态]
     * @return boolean
     **/
    @Override
    public boolean updateUserMemberStateByUid(Integer uid, Integer member_state) {
        //1).根据用户主键id查询用户所有信息
        ShopUser shopUser = shopUserMapper.selectById(uid);
        //2).修改用户的会员状态
        shopUser.setMember_state(member_state);
        //3).保存修改
        int i = shopUserMapper.updateById(shopUser);
        //4).判断并返回值
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserStateByUids(String uids) {
        //1).字符创切割
        String[] split = uids.split(",");
        //2).遍历查询
        for (String s : split) {
            //3).通过id查询用户的数据
            ShopUser shopUser = shopUserMapper.selectById(Integer.parseInt(s));
            //4).修改状态
            shopUser.setState(1);
            //5).保存修改
            shopUserMapper.updateById(shopUser);
        }
        //6).返回值
        return true;
    }
}
