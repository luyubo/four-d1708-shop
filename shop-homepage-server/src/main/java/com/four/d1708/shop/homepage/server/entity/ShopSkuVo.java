package com.four.d1708.shop.homepage.server.entity;

import com.four.d1708.shop.entityinterface.entity.ShopSku;
import lombok.Data;

@Data
public class ShopSkuVo extends ShopSku {

    private String pname;
    private String ppic;
    private  String cname;

    public String getPname() {
        return pname;
    }

    public String getPpic() {
        return ppic;
    }

    public String getCname() {
        return cname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPpic(String ppic) {
        this.ppic = ppic;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
