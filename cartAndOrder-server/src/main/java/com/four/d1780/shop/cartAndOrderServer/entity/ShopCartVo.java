package com.four.d1780.shop.cartAndOrderServer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.four.d1708.shop.entityinterface.entity.ShopCart;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ShopCartVo extends ShopCart implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer skid;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品卖点
     */
    @TableField("sell_point")
    private String sell_point;

    /**
     * 商品价格，单位为：元
     */
    private BigDecimal price;

    /**
     * 商品图片
     */
    private String image;


    /**
     * 商品数量
     */
    private int amount;

    private Integer cid;

}