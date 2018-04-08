package com.illegalaccess.gateway.strategy.auth;

import com.illegalaccess.gateway.common.enums.APIAuthTypeEnum;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.strategy.SecurityAuthStrategy;
import org.springframework.stereotype.Service;

/**
 * 未知的安全认证方式, 即非法请求
 */
@Service
public class InvalidSecurityStrategy implements SecurityAuthStrategy {

    @Override
    public APIAuthTypeEnum getAuthType() {
        return APIAuthTypeEnum.Invalid;
    }

    @Override
    public boolean doAuth(HttpRequestDTO dto) {
        return false;
    }
}
