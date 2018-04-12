package com.illegalaccess.gateway.enhance.post;

import com.illegalaccess.gateway.common.enums.APIEnhancementTypeEnum;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.enhance.AbstractEnhancer;
import com.illegalaccess.gateway.enhance.EnhanceExecuteType;
import com.illegalaccess.gateway.enhance.support.ConcurrentContainer;
import org.springframework.stereotype.Service;
import java.util.concurrent.Semaphore;

@Service
public class PostConcurrentEnhancement implements AbstractEnhancer {

    @Override
    public String enhancerName() {
        return "PostConcurrentEnhancement";
    }

    @Override
    public EnhanceExecuteType getType() {
        return EnhanceExecuteType.post;
    }

    @Override
    public APIEnhancementTypeEnum getAPIEnhanceType() {
        return APIEnhancementTypeEnum.ConcurrentLimitEnhancement;
    }

    @Override
    public boolean enhance(HttpRequestDTO dto, String condition) {
        Semaphore semaphore = ConcurrentContainer.getAndClear();
        semaphore.release();
        return true;
    }
}
