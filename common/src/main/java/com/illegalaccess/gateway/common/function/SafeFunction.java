package com.illegalaccess.gateway.common.function;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class SafeFunction {

    public static <T, R> R execInSafeMode(Function<T, R> function, Supplier<R> supplier, T argument) {
        try{
            return function.apply(argument);
        } catch (Exception e) {
            log.error("exec in safe mode fail, argument is:{}", e, argument);
        }
        return supplier.get();
    }

}
