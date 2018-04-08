package com.illegalaccess.gateway.enhance.pre;

import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.enhance.AbstractEnhancer;
import com.illegalaccess.gateway.enhance.EnhancerType;
import org.springframework.stereotype.Service;


/**
 * 安全认证
 */
@Service
public class SecurityEnhancement implements AbstractEnhancer {

    @Override
    public String enhancerName() {
        return "SecurityEnhancement";
    }

    @Override
    public EnhancerType getType() {
        return EnhancerType.pre;
    }

    @Override
    public boolean enhance(HttpRequestDTO dto, String condition) {
        return false;
    }
}
