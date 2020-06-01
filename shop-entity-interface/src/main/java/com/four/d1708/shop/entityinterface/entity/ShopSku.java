package com.four.d1708.shop.entityinterface.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableField("sell_point")
    private String sell_point;

    /**
     * 商品价格，单位为：元
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    @TableField("stock_count")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date create_time;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private Date update_time;

    /**
     * spu的id
     */
    @TableField("spu_id")
    private Integer spu_id;

    /**
     * 商品属性
     */
    @TableField("spec_name")
    private String spec_name;

    /**
     * 商品属性值
     */
    @TableField("option_name")
    private String option_name;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSell_point() {
        return sell_point;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock_count() {
        return stock_count;
    }

    public String getImage() {
        return image;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public Integer getSpu_id() {
        return spu_id;
    }

    public String getSpec_name() {
        return spec_name;
    }

    public String getOption_name() {
        return option_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSell_point(String sell_point) {
        this.sell_point = sell_point;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock_count(Integer stock_count) {
        this.stock_count = stock_count;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public void setSpu_id(Integer spu_id) {
        this.spu_id = spu_id;
    }

    public void setSpec_name(String spec_name) {
        this.spec_name = spec_name;
    }

    public void setOption_name(String option_name) {
        this.option_name = option_name;
    }
}
