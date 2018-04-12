package com.illegalaccess.gateway;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DateTimeTest {

    @Test
    public void timeTest() {
//        LocalTime lt = LocalTime.now();
//        System.out.println(lt);
//        System.out.println(lt.getLong(ChronoField.MICRO_OF_DAY));
//        System.out.println(lt.getLong(ChronoField.MICRO_OF_SECOND));

        LocalDateTime t1 = LocalDateTime.now();
//        LocalDateTime t2 = t1.plusHours(12).plusMinutes(20);
        LocalDateTime t2 = t1.plusMinutes(2);

        System.out.println(t1);
        System.out.println(t2);
        Duration d = Duration.between(t1, t2);
        System.out.println(d);

        System.out.println(ChronoUnit.MICROS.between(t1, t2));

    }

    @Test
    public void mapDefaultTest() {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        String value = map.getOrDefault("hello", "world");
        System.out.println("value===" + value);
        String v2 = map.get("hello");
        System.out.println("v2=====" + v2);
    }
}
