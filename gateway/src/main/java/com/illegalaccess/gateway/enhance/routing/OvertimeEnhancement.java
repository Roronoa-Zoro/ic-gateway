package com.illegalaccess.gateway.enhance.routing;

import com.illegalaccess.gateway.common.enums.APIEnhancementTypeEnum;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.enhance.AbstractEnhancer;
import com.illegalaccess.gateway.enhance.EnhanceExecuteType;

/**
 * 对接口请求的超时进行限制
 */
public class OvertimeEnhancement implements AbstractEnhancer {

    @Override
    public String enhancerName() {
        return "OvertimeEnhancement";
    }

    @Override
    public EnhanceExecuteType getType() {
        return EnhanceExecuteType.routing;
    }

    @Override
    public APIEnhancementTypeEnum getAPIEnhanceType() {
        return APIEnhancementTypeEnum.OverTimeEnhancement;
    }

    @Override
    public boolean enhance(HttpRequestDTO dto, String condition) {
        return false;
    }
}
