package com.four.d1780.shop.cartAndOrderServer.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wh
 * @since 2020-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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
    private int pnum;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    /**
     * 总价
     */
    @TableField("sum_total")
    private BigDecimal sumTotal;


}
