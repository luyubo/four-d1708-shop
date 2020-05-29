package com.four.d1708.shop.entityinterface.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
    private String goods_name;

    /**
     * 是否上架
     */
    private String is_marketable;

    /**
     * 所属产品
     */
    private Integer category_id;

    /**
     * 小图
     */
    private String small_pic;


}
