package com.illegalaccess.gateway.netty.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * 允许 多个 inbound handler 链式执行
 * 当isLastInbound为false, 则会触发后续的 handler
 * 当到达最后一个handler时, 执行完逻辑 会释放资源
 * @param <T>
 */
public abstract class AbstractChannelInboundHandler<T> extends ChannelInboundHandlerAdapter {

    private boolean isLastInbound = false;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        T message = (T) msg;
        messageReceived(ctx, message);
        if (isLastInbound) {
            ReferenceCountUtil.release(msg);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    /**
     * 处理消息的实际方法
     * @param ctx
     * @param msg
     */
    protected abstract void messageReceived(ChannelHandlerContext ctx, T msg);
}
