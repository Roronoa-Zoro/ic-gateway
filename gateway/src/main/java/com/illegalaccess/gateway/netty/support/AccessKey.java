package com.illegalaccess.gateway.netty.support;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccessKey {

    private String serviceId;

    private String url;

    private LocalDateTime accessTime;
}
