package com.tutu.reading.think_in_java.multiplex_practice.abstract_practice;

import org.apache.http.client.HttpClient;
import org.slf4j.event.Level;

import java.io.IOException;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 14:49$
 * @Version: 1.0
 */
public class MessageLogger extends Logger {
    private HttpClient msgClient;

    public MessageLogger(String name, boolean enabled, Level minPermittedLevel, HttpClient msgClient) {
        super(name, enabled, minPermittedLevel);
        this.msgClient = msgClient;
    }

    @Override
    public void log(Level level, String message) throws IOException {
        super.log(level, message);
    }

    @Override
    protected void doLog(Level level, String message) {
        System.out.println(msgClient.toString());;
    }
}
