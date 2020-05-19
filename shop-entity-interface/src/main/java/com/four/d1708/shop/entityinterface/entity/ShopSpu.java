package com.four.d1708.shop.entityinterface.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author luyubo
 * @Title: ShopSpu
 * @Package entity
 * @Description: 商品实体类
 * @date 2020/5/19/23:01
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("shop_spu")
public class ShopSpu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * spu主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * SPU名字
     */
    private String goodsName;

    /**
     * 是否上架
     */
    private String isMarketable;

    /**
     * 所属产品
     */
    private Integer categoryId;

    /**
     * 小图
     */
    private String smallPic;


}
