package com.illegalaccess.gateway.strategy.auth;

import com.illegalaccess.gateway.common.enums.APIAuthTypeEnum;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.strategy.SecurityAuthStrategy;
import org.springframework.stereotype.Service;

@Service
public class RequestIDSecurityStrategy implements SecurityAuthStrategy {

    @Override
    public APIAuthTypeEnum getAuthType() {
        return APIAuthTypeEnum.SingleToken;
    }

    @Override
    public boolean doAuth(HttpRequestDTO dto) {
        return false;
    }
}
