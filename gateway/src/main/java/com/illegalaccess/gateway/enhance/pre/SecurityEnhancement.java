package com.illegalaccess.gateway.enhance.pre;

import com.illegalaccess.gateway.common.enums.APIAuthTypeEnum;
import com.illegalaccess.gateway.common.enums.APIEnhancementTypeEnum;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.enhance.AbstractEnhancer;
import com.illegalaccess.gateway.enhance.EnhanceExecuteType;
import com.illegalaccess.gateway.strategy.SecurityAuthStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * 安全认证
 */
@Slf4j
@Service
public class SecurityEnhancement implements AbstractEnhancer {

    @Resource
    private List<SecurityAuthStrategy> authStrategyList;
    private ConcurrentMap<APIAuthTypeEnum, SecurityAuthStrategy> authStrategyHolder;

    @PostConstruct
    public void init() {
        authStrategyHolder = new ConcurrentHashMap<>(authStrategyList.size());
        authStrategyList.forEach(sas -> authStrategyHolder.put(sas.getAuthType(), sas));
    }

    @Override
    public String enhancerName() {
        return "SecurityEnhancement";
    }

    @Override
    public EnhanceExecuteType getType() {
        return EnhanceExecuteType.pre;
    }

    @Override
    public APIEnhancementTypeEnum getAPIEnhanceType() {
        return APIEnhancementTypeEnum.AuthEnhancement;
    }

    /**
     * condition 是APIAuthTypeEnum的authTypeName
     * @param dto
     * @param condition
     * @return
     */
    @Override
    public boolean enhance(HttpRequestDTO dto, String condition) {
        APIAuthTypeEnum authType = APIAuthTypeEnum.getAuthTypeByValud(condition);
        boolean pass = authStrategyHolder.get(authType).doAuth(dto);
        log.info("{} fire auth strategy:{} for requestId:{}, result is :{}",
                enhancerName(), authType.getAuthTypeName(), dto.getRequestId(), pass);
        return pass;
    }
}
