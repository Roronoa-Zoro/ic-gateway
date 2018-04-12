package com.illegalaccess.gateway.enhance.pre;

import com.illegalaccess.gateway.common.enums.APIEnhancementTypeEnum;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.enhance.AbstractEnhancer;
import com.illegalaccess.gateway.enhance.EnhanceExecuteType;
import com.illegalaccess.gateway.enhance.support.ConcurrentContainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * api 并发调用限制
 */
@Slf4j
@Service
public class PreConcurrentEnhancement implements AbstractEnhancer {

    private ConcurrentMap<String, Semaphore> semaHolder = new ConcurrentHashMap<>();

    @Override
    public String enhancerName() {
        return "ConcurrentEnhancement";
    }

    @Override
    public EnhanceExecuteType getType() {
        return EnhanceExecuteType.pre;
    }

    @Override
    public APIEnhancementTypeEnum getAPIEnhanceType() {
        return APIEnhancementTypeEnum.ConcurrentLimitEnhancement;
    }

    /**
     * condition是 json格式
     * {
     *     permit:111,
     *     wait:10(单位是ms)
     * }
     * @param dto
     * @param condition
     * @return
     */
    @Override
    public boolean enhance(HttpRequestDTO dto, String condition) {
        Semaphore sema = semaHolder.get(dto.getRequestUrl());
        if (sema == null) {
            sema = new Semaphore(Integer.valueOf(condition));
            semaHolder.putIfAbsent(dto.getRequestUrl(), sema);
        }

        boolean getPermit = sema.tryAcquire();
        if (getPermit) {
            ConcurrentContainer.putSemaphore(sema);
            return true;
        }
        log.info("concurrent invoke for url:{} exceed max permit:{}", dto.getRequestUrl());
        return false;
    }
}
