package com.four.d1780.shop.cartAndOrderServer.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    //返回码
    private Integer code;
    //返回状态信息
    private String msg;
    //返回数据
    private Object data;

    public ResultEntity(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //返回ok的数据格式
    public static ResultEntity ok(Object data) {
        return new ResultEntity(1001, "Ok", data);
    }

    //返回erro的数据格式
    public static ResultEntity erro(Object data) {
        return new ResultEntity(4001, "Erro", data);
    }

}