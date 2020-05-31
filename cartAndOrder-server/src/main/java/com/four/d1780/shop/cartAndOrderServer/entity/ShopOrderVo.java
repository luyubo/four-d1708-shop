package com.four.d1780.shop.cartAndOrderServer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.four.d1708.shop.entityinterface.entity.ShopOrder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShopOrderVo extends ShopOrder {

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品卖点
     */
    @TableField("sell_point")
    private String sellPoint;

    /**
     * 商品价格，单位为：元
     */
    private BigDecimal price;

    /**
     * 商品图片
     */
    private String image;

}
