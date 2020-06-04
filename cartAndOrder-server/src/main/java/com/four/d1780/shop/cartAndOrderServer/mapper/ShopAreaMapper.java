package com.four.d1780.shop.cartAndOrderServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.four.d1708.shop.entityinterface.entity.ShopAddr;
import com.four.d1708.shop.entityinterface.entity.ShopArea;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ShopAreaMapper extends BaseMapper<ShopArea> {

    List<ShopArea> list(Integer uid);

    @Update("UPDATE shop_addr a SET state=1 WHERE a.`id`=#{addrId}  AND a.uid=#{uid}")
    int updateAddrStateByUidAndAddrId(@Param("uid") Integer uid, @Param("addrId")Integer addrId);

    @Select("SELECT a.* FROM shop_addr a WHERE a.`id`=#{addrId}  AND a.uid=#{uid}")
    List<ShopAddr> findByUidAndAddrId(Integer uid);

    @Update("UPDATE shop_addr a SET state=0 WHERE a.`id`=#{addrId}  AND a.uid=#{uid}")
    int updateAddrStateByUidAndAddrId2(Integer uid, Integer addrId);

    @Select("SELECT a.* FROM shop_addr a WHERE a.`uid`=#{addrId}  AND a.state=1")
    ShopAddr findByUidAndState(Integer uid);
}
