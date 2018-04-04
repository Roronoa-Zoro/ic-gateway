package com.illegalaccess.gateway.common.enums;

public enum APIProtocolEnum {

    HTTP("http", "http协议"),
    DUBBO("dubbo", "dubbo协议");

    private String protocol;
    private String protocolDesc;

    APIProtocolEnum(String protocol, String protocolDesc) {
        this.protocol = protocol;
        this.protocolDesc = protocolDesc;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getProtocolDesc() {
        return protocolDesc;
    }
}
