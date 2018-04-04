package com.illegalaccess.gateway.dto;

import lombok.Data;

@Data
public class HttpResponseDTO {

    /**
     * 接口的版本
     */
    private String version;

    /**
     * 网关的 返回code, 该值正常表示 调用正常，具体业务是否正确
     * 需要坚持 业务方 返回的数据
     */
    private String respCode;

    /**
     * 网关返回 code的说明
     */
    private String respDesc;

    /**
     * 实际业务服务提供方  返回的数据, json 格式
     */
    private String response;
}
