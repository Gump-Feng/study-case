package com.tutu.reading.think_in_java.multiplex_practice.extend_practice;

import org.slf4j.event.Level;

import java.io.Writer;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 14:55$
 * @Version: 1.0
 */
public class FileLogger extends Logger {
    private Writer writer;

    public FileLogger(String name, boolean enabled, Level minPermittedLevel) {
        super(name, enabled, minPermittedLevel);
    }

    @Override
    public void log(Level level, String message) {
        super.log(level, message);
    }
}
