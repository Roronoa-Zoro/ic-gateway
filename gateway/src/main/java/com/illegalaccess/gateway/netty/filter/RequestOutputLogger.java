package com.illegalaccess.gateway.netty.filter;

import com.illegalaccess.gateway.netty.support.AccessKey;
import com.illegalaccess.gateway.netty.support.AccessStat;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
public class RequestOutputLogger extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx, msg, promise);
        AccessKey ak = AccessStat.getAndClear();

        log.info("requestId:{} access service:{} cost:{} ms", ak.getServiceId(), ak.getUrl(),
                ChronoUnit.MICROS.between(ak.getAccessTime(), LocalDateTime.now()));
    }
}
