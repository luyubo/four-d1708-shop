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
 * @Title: ShopArea
 * @Package entity
 * @Description: 地址实体类
 * @date 2020/5/19/23:01
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("shop_area")
public class ShopArea implements Serializable {

    private static final long serialVersionUID=1L;
    //地区主键id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //地区名称
    private String name;
    //地区父id
    private Integer pid;
}
