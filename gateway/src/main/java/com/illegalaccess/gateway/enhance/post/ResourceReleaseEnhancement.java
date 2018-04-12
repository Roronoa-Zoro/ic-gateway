package com.illegalaccess.gateway.enhance.post;

import com.illegalaccess.gateway.common.enums.APIEnhancementTypeEnum;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.enhance.AbstractEnhancer;
import com.illegalaccess.gateway.enhance.EnhanceExecuteType;

public class ResourceReleaseEnhancement implements AbstractEnhancer {
    @Override
    public String enhancerName() {
        return "ResourceReleaseEnhancement";
    }

    @Override
    public EnhanceExecuteType getType() {
        return EnhanceExecuteType.post;
    }

    @Override
    public APIEnhancementTypeEnum getAPIEnhanceType() {
        return null;
    }

    @Override
    public boolean enhance(HttpRequestDTO dto, String condition) {
        return false;
    }
}
