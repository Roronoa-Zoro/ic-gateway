package com.illegalaccess.gateway;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageableResultBean<T> implements Serializable {

    private List<T> data; //数据

    private String respCode;

    private String respMsg;

    private Integer total; // 总记录数, 不建议使用

    private Integer currentLimit; // 此次返回的记录数
}
