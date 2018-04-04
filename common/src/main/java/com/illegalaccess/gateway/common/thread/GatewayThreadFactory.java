package com.illegalaccess.gateway.common.thread;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class GatewayThreadFactory implements ThreadFactory {

    private final AtomicInteger ai = new AtomicInteger(0);

    private final String defaultThreadName = "gatewayThread";

    private String threadName = defaultThreadName;
    private boolean deamon = false;

    public GatewayThreadFactory() {
    }

    public GatewayThreadFactory(String threadName) {
        this.threadName = threadName;
    }

    public GatewayThreadFactory(String threadName, boolean deamon) {
        this.threadName = threadName;
        this.deamon = deamon;
    }

    public GatewayThreadFactory(boolean deamon) {
        this.deamon = deamon;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, threadName + "-" + ai.getAndIncrement());
        t.setDaemon(deamon);
        return t;
    }
}
