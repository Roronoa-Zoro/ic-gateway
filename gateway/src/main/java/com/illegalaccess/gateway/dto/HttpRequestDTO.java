package com.illegalaccess.gateway.dto;

import lombok.Data;

@Data
public class HttpRequestDTO {

    /**
     * 网关 分配给调用方的ID
     */
    private String requestId;
    /**
     * 接口的版本
     */
    private String version;

    /**
     * 可以是纯粹的token
     * 也可以是签名
     */
    private String token;

    /**
     * 实际的数据  json格式
     */
    private String data;

    /**
     * 客户端发送请求 时间 yyyy-MM-dd HH-mm-ss:SSS
     */
    private String sendTime;

    private String requestUrl;//请求过来的URL
}
