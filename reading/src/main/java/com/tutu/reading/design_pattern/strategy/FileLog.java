package com.tutu.reading.design_pattern.strategy;

/**
 * @Description:
 * @Author: hxf
 * @CreateDate: 2020/12/30 17:29
 * @Version: 1.0
 */
public class FileLog implements LogStrategy {
    @Override
    public void log(String msg) {
        System.out.println("现在把 '"+msg+"' 记录到文件中");
    }
}
