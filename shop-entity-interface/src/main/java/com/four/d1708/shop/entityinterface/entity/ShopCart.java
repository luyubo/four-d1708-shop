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
 * @Title: ShopCart
 * @Package entity
 * @Description: 购物车实体类
 * @date 2020/5/19/23:03
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("shop_cart")
public class ShopCart implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 购物车主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 商品id(商品型号)
     */
    private String skuid;

    /**
     * 购买数量
     */
    private BigDecimal pnum;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 总价
     */
    private BigDecimal sumTotal;


}
