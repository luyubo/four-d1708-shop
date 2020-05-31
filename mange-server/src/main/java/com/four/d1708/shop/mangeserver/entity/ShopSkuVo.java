package com.four.d1708.shop.mangeserver.entity;

import com.four.d1708.shop.entityinterface.entity.ShopSku;
import lombok.Data;

/**
 * @author luyubo
 * @Title: ShopSkuVo
 * @Package entity
 * @Description: sku的实体扩展类
 * @date 2020/5/31/19:06
 * @Version 1.0
 */
@Data
public class ShopSkuVo extends ShopSku {
    private Integer skuId;
    private Integer spuId;
}
