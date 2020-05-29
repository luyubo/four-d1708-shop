package com.four.d1708.shop.entityinterface.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@TableName("shop_cartdetail")
public class ShopCartdetail implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 购物车表
     */
    private Integer cartId;

    /**
     * sku的id
     */
    private Integer skuid;

    /**
     * 标题
     */
    private String title;

    /**
     * 卖点
     */
    private String sell_point;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 盘点
     */
    private Integer stock_count;

    /**
     * 图片
     */
    private String image;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;

    /**
     * spu的id
     */
    private Integer spu_id;

    /**
     * 购买数量
     */
    private Integer amount;

    /**
     * 选中的地址
     */
    private Integer addrId;


}
