package com.illegalaccess.gateway.strategy.auth;

import com.illegalaccess.gateway.common.entity.ClientRequestInfo;
import com.illegalaccess.gateway.common.enums.APIAuthTypeEnum;
import com.illegalaccess.gateway.common.service.APIService;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.strategy.SecurityAuthStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Slf4j
@Service
public class RequestIDSecurityStrategy implements SecurityAuthStrategy {

    @Resource
    private APIService apiService;

    @Override
    public APIAuthTypeEnum getAuthType() {
        return APIAuthTypeEnum.SingleToken;
    }

    @Override
    public boolean doAuth(HttpRequestDTO dto) {
        ClientRequestInfo client = apiService.getClientInfoById(dto.getRequestId());
        if (client == null) {
            log.info("check requestId:{} false, find nothing", dto.getRequestId());
            return false;
        }

        return true;
    }
}
