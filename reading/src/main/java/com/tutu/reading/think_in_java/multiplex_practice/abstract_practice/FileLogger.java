package com.tutu.reading.think_in_java.multiplex_practice.abstract_practice;

import org.slf4j.event.Level;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 14:45$
 * @Version: 1.0
 */
public class FileLogger extends Logger {
    private Writer writer;

    public FileLogger(String name, boolean enabled, Level minPermittedLevel, String filePath) throws IOException {
        super(name, enabled, minPermittedLevel);
        this.writer = new FileWriter(filePath);
    }

    @Override
    protected void doLog(Level level, String message) throws IOException {
        writer.write("");
    }
}
