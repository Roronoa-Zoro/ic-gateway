package com.illegalaccess.gateway.netty.handler;

import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 进行 协议转换
 * 即把 http 的请求，转成 对应的接口形式(http/dubbo)访问实际的服务提供者
 */
public class ProcotolTransitHandler extends ChannelInboundHandlerAdapter {
}
