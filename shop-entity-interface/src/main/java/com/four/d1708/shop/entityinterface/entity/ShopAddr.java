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
@TableName("shop_addr")
public class ShopAddr implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 省id
     */
    private Integer province_id;

    /**
     * 市id
     */
    private Integer city_id;

    /**
     * 县id
     */
    private Integer country_id;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 状态 0正常 1删除
     */
    private Integer state;


}
