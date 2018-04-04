package com.illegalaccess.gateway.netty;

import com.illegalaccess.gateway.dto.HttpRequestDTO;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.Data;

@Data
public class NettyHttpRequest {

    private FullHttpRequest httpRequest;

    private HttpRequestDTO request;
}
