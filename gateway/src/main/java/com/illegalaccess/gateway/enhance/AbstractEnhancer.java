package com.illegalaccess.gateway.enhance;

import com.illegalaccess.gateway.dto.HttpRequestDTO;

public interface AbstractEnhancer {

    String enhancerName();

    EnhancerType getType();

    boolean enhance(HttpRequestDTO dto, String condition);
}
