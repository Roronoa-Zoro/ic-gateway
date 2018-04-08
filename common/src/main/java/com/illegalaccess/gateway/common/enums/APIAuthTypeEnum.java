package com.illegalaccess.gateway.common.enums;

import com.illegalaccess.gateway.common.function.SafeFunction;

/**
 * 安全认证方式
 * token即 网关分配给 客户端系统的  requestId
 */
public enum APIAuthTypeEnum {

    Invalid(-1, "invalid", "无效的方式"),
    SingleToken(1, "token", "单独网关系统分配的一个token, 默认方式"),
    TokenPlusIP(2, "token+ip", "网关分配的token+白名单"),
    Signature(3, "signature", "方法签名验证+token"),
    SignaturePlusIP(4, "signature+ip", "方法签名+白名单+token");

    private Integer authType;
    private String authTypeName;
    private String authTypeDesc;

    APIAuthTypeEnum(Integer authType, String authTypeName, String authTypeDesc) {
        this.authType = authType;
        this.authTypeName = authTypeName;
        this.authTypeDesc = authTypeDesc;
    }

    public Integer getAuthType() {
        return authType;
    }

    public String getAuthTypeName() {
        return authTypeName;
    }

    public String getAuthTypeDesc() {
        return authTypeDesc;
    }

    public static APIAuthTypeEnum getAuthTypeByValud(String authType) {
        Integer type = SafeFunction.execInSafeMode((ar) -> Integer.valueOf(ar), () -> Integer.valueOf(-1), authType);
        for (APIAuthTypeEnum aat : APIAuthTypeEnum.values()) {
            if (aat.getAuthType().compareTo(type) == 0) {
                return aat;
            }
        }

        return Invalid;
    }
}
