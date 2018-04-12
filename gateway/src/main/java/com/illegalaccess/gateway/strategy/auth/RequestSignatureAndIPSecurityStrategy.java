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
 * 数字签名+ip白名单 安全检查
 */
@Slf4j
@Service
public class RequestSignatureAndIPSecurityStrategy implements SecurityAuthStrategy {

    @Resource
    private APIService apiService;

    @Resource
    private RequestSignatureSecurityStrategy signatureSecurityStrategy;

    @Override
    public APIAuthTypeEnum getAuthType() {
        return APIAuthTypeEnum.SignaturePlusIP;
    }

    @Override
    public boolean doAuth(HttpRequestDTO dto) {
        boolean pass = signatureSecurityStrategy.doAuth(dto);
        if (!pass) {
            log.info("check requestId or signature fail");
            return pass;
        }

        ClientRequestInfo client = apiService.getClientInfoById(dto.getRequestId());
        String ipList = client.getClientIPList();
        pass = ipList.contains(dto.getClientIp());
        log.info("client ip:{} is allowed:{}", dto.getClientIp(), pass);
        return pass;
    }
}
