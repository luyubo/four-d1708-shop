package com.four.d1708.shop.entityinterface.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
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
    private LocalDate createtime;

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
     * 0待支付 1已支付 2过期未支付
     */
    private Integer state;


}
