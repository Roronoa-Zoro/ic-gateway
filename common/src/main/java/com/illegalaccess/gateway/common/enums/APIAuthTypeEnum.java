package com.illegalaccess.gateway.common.enums;

import com.illegalaccess.gateway.common.function.SafeFunction;

/**
 * 安全认证方式
 */
public enum APIAuthTypeEnum {

    Invalid(-1, "invalid", "无效的方式"),
    SingleToken(1, "token", "单独网关系统分配的一个token, 默认方式"),
    IPList(2, "ip", "白名单验证"),
    TokenPlusIP(3, "token+ip", "网关分配的token+白名单"),
    Signature(4, "signature", "方法签名验证"),
    SignaturePlusIP(5, "signature+ip", "方法签名+白名单");

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
