package com.tutu.reading.httpdemo;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HttpDemoApplicationTests {


    @Test
    public void httpGet() {
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("alice", "sadf");
        linkedHashMap.put("白百合", "sadf");
        linkedHashMap.put("张无忌", "sadf");
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

    }



}
