package com.illegalaccess.gateway.netty.support;

public class AccessStat {

    private static ThreadLocal<AccessKey> holder = new ThreadLocal<>();

    public static void addAccessTime(AccessKey ak) {
        holder.set(ak);
    }

    public static AccessKey getAndClear() {
        AccessKey ak = holder.get();
        holder.remove();
        return ak;
    }
}
