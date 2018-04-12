package com.illegalaccess.gateway.enhance.support;

import java.util.concurrent.Semaphore;

public class ConcurrentContainer {

    public static ThreadLocal<Semaphore> container = new ThreadLocal<>();

    public static void putSemaphore(Semaphore semaphore) {
        container.set(semaphore);
    }

    public static Semaphore getAndClear() {
        Semaphore semaphore = container.get();
        container.remove();
        return semaphore;
    }
}
