package com.four.d1708.shop.entityinterface.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName("shop_orderdetail")
public class ShopOrderdetail implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    private Integer order_id;

    /**
     * sku的id
     */
    private Integer sku_id;

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
    private String stock_count;

    private String image;

    /**
     * 状态 0正常 1删除
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
     * 地址表的id
     */
    private Integer addr_id;


}
