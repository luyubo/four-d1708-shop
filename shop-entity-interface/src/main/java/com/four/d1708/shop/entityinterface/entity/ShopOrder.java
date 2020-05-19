package com.four.d1708.shop.entityinterface.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author luyubo
 * @Title: ShopOrder
 * @Package entity
 * @Description: 订单实体类
 * @date 2020/5/19/23:01
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("shop_order")
public class ShopOrder implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单id
     */
    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 送货地址
     */
    private String address;

    /**
     * 订单生成日期
     */
    private Date createtime;

    /**
     * 商品id
     */
    private Integer skuid;

    /**
     * 购买数量
     */
    private Integer pnum;

    /**
     * 总价
     */
    private BigDecimal sum;

    /**
     * 省id
     */
    private Integer provinceId;

    /**
     * 市id
     */
    private Integer cityId;

    /**
     * 县id
     */
    private Integer countryId;


}
