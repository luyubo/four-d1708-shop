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
 * 商品表
 * </p>
 *
 * @author luyubo
 * @since 2020-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("shop_sku")
public class ShopSku implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 商品id，同时也是商品编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品卖点
     */
    private String sell_point;

    /**
     * 商品价格，单位为：元
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    private Integer stock_count;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;

    /**
     * spu的id
     */
    private Integer spu_id;

    /**
     * 商品属性
     */
    private String spec_name;

    /**
     * 商品属性值
     */
    private String option_name;


}
