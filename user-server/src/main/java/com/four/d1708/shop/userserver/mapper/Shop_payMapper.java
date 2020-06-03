package com.four.d1708.shop.userserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopPay;
import com.four.d1708.shop.userserver.entity.ShopPayVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yinshijie
 * @since 2020-05-31
 */
@Mapper
public interface Shop_payMapper extends BaseMapper<ShopPay> {

    @Insert(" insert into Shop_pay set account_num=#{account_num},password=#{password},money=#{money},state=#{state},uid=#{uid} ")
    void addpay(ShopPay shop_pay);

    ShopPayVo findPayByUid(Integer uid);

    ShopPayVo getPayByAmountNumAndPassword(String account_num, String password);
}
