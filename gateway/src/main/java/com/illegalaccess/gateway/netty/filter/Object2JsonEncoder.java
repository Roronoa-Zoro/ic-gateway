package com.illegalaccess.gateway.netty.filter;

import com.alibaba.fastjson.JSON;
import com.illegalaccess.gateway.dto.HttpResponseDTO;
import com.illegalaccess.gateway.netty.NettyHttpResponse;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.*;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 把返回的数据转成 json， 返回给客户端
 */
public class Object2JsonEncoder extends MessageToMessageEncoder<NettyHttpResponse> {


    protected void encode(ChannelHandlerContext ctx, NettyHttpResponse msg, List<Object> out) throws Exception {
        FullHttpResponse httpResponse = msg.getHttpResponse();
        HttpResponseDTO data = msg.getResponse();
        String body = JSON.toJSONString(data);
        ByteBuf bb = Unpooled.copiedBuffer(body, Charset.forName("utf-8"));
        if (httpResponse == null) {
            httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, bb);
        } else {
            httpResponse = new DefaultFullHttpResponse(msg.getHttpResponse().protocolVersion(),
                    msg.getHttpResponse().status(), bb);
        }

        httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON);
        httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, bb.readableBytes());
        out.add(httpResponse);
    }
}
