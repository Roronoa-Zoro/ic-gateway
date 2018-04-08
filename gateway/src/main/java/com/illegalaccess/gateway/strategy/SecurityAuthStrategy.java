package com.illegalaccess.gateway.strategy;

import com.illegalaccess.gateway.common.enums.APIAuthTypeEnum;
import com.illegalaccess.gateway.dto.HttpRequestDTO;

public interface SecurityAuthStrategy {

    APIAuthTypeEnum getAuthType();

    boolean doAuth(HttpRequestDTO dto);
}
