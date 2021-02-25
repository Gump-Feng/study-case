package com.tutu.reading.design_pattern.strategy;

/**
 * @Description:
 * @Author: hxf
 * @CreateDate: 2020/12/30 17:28
 * @Version: 1.0
 */
public class DbLog implements LogStrategy {
    @Override
    public void log(String msg) {
        System.out.println("现在把 '"+msg+"' 记录到数据库中");
    }
}
