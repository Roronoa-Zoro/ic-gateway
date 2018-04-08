package com.illegalaccess.gateway.common.entity;

import lombok.Data;

/**
 * 客户端访问该网关时，网关给他们分配的requestID
 * redis 使用hash存储，key是requestId
 */
@Data
public class ClientRequestInfo {

    public static final String tableName = "ClientRequestInfo";

    private String requestId;

    private String clientName;

    private String clientDesc;

    private String clientIPList; // 客户端访问的ip地址列表, 逗号分隔多个地址
}
