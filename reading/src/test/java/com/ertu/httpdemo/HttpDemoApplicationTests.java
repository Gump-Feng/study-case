package com.ertu.httpdemo;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class HttpDemoApplicationTests {


    @Test
    public void httpGet() {
        Jedis jedis = new Jedis();

        System.out.println(Integer.MAX_VALUE);
    }



}
