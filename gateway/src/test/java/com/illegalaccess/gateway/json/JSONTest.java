package com.illegalaccess.gateway.json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JSONTest {

    @Test
    public void jsonTest() {
        List<KeyValuePair> kv = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            KeyValuePair p = new KeyValuePair();
            p.setType(i + "");
            p.setData("data=" + i);
            kv.add(p);
        }

        System.out.println(JSON.toJSONString(kv));
    }
}
