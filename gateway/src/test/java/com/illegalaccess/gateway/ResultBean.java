package com.illegalaccess.gateway;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {
    private T data;

    /**
     * 返回码和返回消息可以通过 enum 定义 一组模型
     */
    private String respCode;

    private String respMsg;
}
