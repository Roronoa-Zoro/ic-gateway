package com.illegalaccess.gateway.common.enums;

public enum APIEnhancementTypeEnum {

    RateLimitEnhancement("rateLimit", "进行流量控制"),
    ConcurrentLimitEnhancement("conLimit", "进行并发调用控制"),
    MonitorLimitEnhancement("monitorLimit", "进行监控"),
    OverTimeEnhancement("overtime", "请求超时控制"),
    CacheDataEnhancement("cache", "进行数据缓存控制"),
    AuthEnhancement("auth", "进行安全认证控制");

    private String enhanceType;
    private String enhanceTypeDesc;

    APIEnhancementTypeEnum(String enhanceType, String enhanceTypeDesc) {
        this.enhanceType = enhanceType;
        this.enhanceTypeDesc = enhanceTypeDesc;
    }
}
