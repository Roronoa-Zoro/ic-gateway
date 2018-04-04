package com.illegalaccess.gateway.netty;

import com.illegalaccess.gateway.dto.HttpResponseDTO;
import io.netty.handler.codec.http.FullHttpResponse;
import lombok.Data;

@Data
public class NettyHttpResponse {

    private FullHttpResponse httpResponse;

    private HttpResponseDTO response;
}
