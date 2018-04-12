package com.illegalaccess.gateway.strategy.auth;

import com.illegalaccess.gateway.common.entity.ClientRequestInfo;
import com.illegalaccess.gateway.common.enums.APIAuthTypeEnum;
import com.illegalaccess.gateway.common.service.APIService;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.strategy.SecurityAuthStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/4/8.
 * ip 白名单检查
 */
@Slf4j
@Service
public class RequestIPSecurityStrategy implements SecurityAuthStrategy {
    @Resource
    private APIService apiService;
    @Resource
    private RequestIDSecurityStrategy idSecurityStrategy;

    @Override
    public APIAuthTypeEnum getAuthType() {
        return APIAuthTypeEnum.TokenPlusIP;
    }

    @Override
    public boolean doAuth(HttpRequestDTO dto) {
        boolean pass = idSecurityStrategy.doAuth(dto);
        log.info("check request id pass:{}", pass);
        if (pass == false) {
            log.info("request id:{} is invalid, will not check ip list", dto.getRequestId());
            return false;
        }

        ClientRequestInfo client = apiService.getClientInfoById(dto.getRequestId());
        String ipList = client.getClientIPList();
        pass = ipList.contains(dto.getClientIp());
        log.info("client ip:{} is allowed:{}", dto.getClientIp(), pass);
        return pass;
    }
}
