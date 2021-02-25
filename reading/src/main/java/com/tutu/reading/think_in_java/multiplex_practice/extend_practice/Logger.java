package com.tutu.reading.think_in_java.multiplex_practice.extend_practice;

import org.slf4j.event.Level;

import java.io.IOException;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 14:54$
 * @Version: 1.0
 */
public class Logger {
    private String name;
    private boolean enabled;
    private Level minPermittedLevel;

    public Logger(String name, boolean enabled, Level minPermittedLevel) {
        this.name = name;
        this.enabled = enabled;
        this.minPermittedLevel = minPermittedLevel;
    }

    protected boolean isLoggable(Level level){
        return enabled && (minPermittedLevel.toInt() <= level.toInt());
    }

    public void log(Level level, String message){

    }

}
