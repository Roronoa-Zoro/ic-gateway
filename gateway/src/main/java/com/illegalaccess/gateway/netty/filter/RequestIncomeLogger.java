package com.illegalaccess.gateway.netty.filter;

import com.illegalaccess.gateway.netty.NettyHttpRequest;
import com.illegalaccess.gateway.netty.support.AccessKey;
import com.illegalaccess.gateway.netty.support.AccessStat;
import io.netty.channel.ChannelHandlerContext;

import java.time.LocalDateTime;

public class RequestIncomeLogger extends AbstractChannelInboundHandler<NettyHttpRequest> {


    protected void messageReceived(ChannelHandlerContext ctx, NettyHttpRequest msg) {
        AccessKey ak = new AccessKey();
        ak.setAccessTime(LocalDateTime.now());
        ak.setServiceId(msg.getRequest().getRequestId());
        ak.setUrl(msg.getHttpRequest().uri());
        AccessStat.addAccessTime(ak);
    }
}
