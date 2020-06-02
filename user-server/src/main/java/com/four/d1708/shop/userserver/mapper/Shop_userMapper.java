package com.four.d1708.shop.userserver.mapper;

import com.four.d1708.shop.entityinterface.entity.ShopUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.userserver.entity.ShopUserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yinshijie
 * @since 2020-05-31
 */
@Mapper
public interface Shop_userMapper extends BaseMapper<ShopUser> {


    ShopUserVo findByNameAndPassword(String name, String password);


    @Insert(" insert into Shop_user set username=#{username},password=#{password},name=#{name},email=#{email},telephone=#{telephone},birthday=#{birthday},sex=#{sex},state=#{state},address=#{address} ")
    void register(ShopUser shop_user);

}
