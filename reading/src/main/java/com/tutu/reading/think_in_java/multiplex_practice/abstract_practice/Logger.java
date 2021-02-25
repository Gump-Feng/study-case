package com.tutu.reading.think_in_java.multiplex_practice.abstract_practice;

import org.slf4j.event.Level;

import java.io.IOException;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 14:41$
 * @Version: 1.0
 */
public abstract class Logger {
    private String name;
    private boolean enabled;
    private Level minPermittedLevel;

    public Logger(String name, boolean enabled, Level minPermittedLevel) {
        this.name = name;
        this.enabled = enabled;
        this.minPermittedLevel = minPermittedLevel;
    }

    public void log(Level level, String message) throws IOException {
        boolean logged = enabled && (minPermittedLevel.toInt() < level.toInt());
        if (!logged) {
            return;
        }
        doLog(level, message);
    }

    protected abstract void doLog(Level level, String message) throws IOException;
}
