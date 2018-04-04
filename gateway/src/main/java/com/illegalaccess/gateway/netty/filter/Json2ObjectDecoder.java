package com.illegalaccess.gateway.netty.filter;

import com.alibaba.fastjson.JSON;
import com.illegalaccess.gateway.dto.HttpRequestDTO;
import com.illegalaccess.gateway.netty.NettyHttpRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.FullHttpRequest;

import java.nio.charset.Charset;
import java.util.List;

/**
 * json 字符串 转成 NettyHttpRequest 解码器
 */
public class Json2ObjectDecoder extends MessageToMessageDecoder<FullHttpRequest> {


    protected void decode(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest, List<Object> list)
            throws Exception {
        if (!fullHttpRequest.getDecoderResult().isSuccess()) {
            //TODO 返回错误
            return;
        }

        NettyHttpRequest request = new NettyHttpRequest();
        request.setHttpRequest(fullHttpRequest);
        String body = fullHttpRequest.content().toString(Charset.forName("utf-8"));
        request.setRequest(JSON.parseObject(body, HttpRequestDTO.class));
        list.add(request);
    }
}
