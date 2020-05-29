package com.four.d1708.shop.entityinterface.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
    private LocalDateTime createtime;

    /**
     * 最后修改时间
     */
    private LocalDateTime updatetime;

    /**
     * 总价
     */
    private BigDecimal sum_total;


}
