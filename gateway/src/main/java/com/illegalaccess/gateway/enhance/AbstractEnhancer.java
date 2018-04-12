package com.illegalaccess.gateway.enhance;

import com.illegalaccess.gateway.common.enums.APIEnhancementTypeEnum;
import com.illegalaccess.gateway.dto.HttpRequestDTO;

public interface AbstractEnhancer {

    String enhancerName();

    EnhanceExecuteType getType();

    APIEnhancementTypeEnum getAPIEnhanceType();

    boolean enhance(HttpRequestDTO dto, String condition);
}
