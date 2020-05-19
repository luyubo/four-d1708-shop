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
 * @Title: ShopCategory
 * @Package entity
 * @Description: 分类实体类
 * @date 2020/5/19/23:01
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("shop_category")
public class ShopCategory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 分类ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类ID=0时，代表的是一级的分类
     */
    private Integer parentId;

    /**
     * 分类名称
     */
    private String name;


}
