package com.tutu.reading.design_pattern.strategy;

/**
 * @Description:
 * @Author: hxf
 * @CreateDate: 2020/12/30 17:30
 * @Version: 1.0
 */
public class LogContext {

    public void log(String msg) {

        LogStrategy strategy = new DbLog();
        try {
            strategy .log(msg);
        } catch(Exception e) {
            // 出错，记录到文件
            strategy = new FileLog();
            strategy.log(msg);
        }
    }
}
