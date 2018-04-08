package com.illegalaccess.gateway.strategy.auth;

import com.illegalaccess.gateway.common.enums.APIAuthTypeEnum;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.strategy.SecurityAuthStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/8.
 */
@Slf4j
@Service
public class RequestSignatureAndIPSecurityStrategy implements SecurityAuthStrategy {
    @Override
    public APIAuthTypeEnum getAuthType() {
        return APIAuthTypeEnum.SignaturePlusIP;
    }

    @Override
    public boolean doAuth(HttpRequestDTO dto) {
        return false;
    }
}
