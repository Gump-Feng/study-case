package com.tutu.mybatis.session;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/8/8$ 15:01$
 * @Version: 1.0
 */
public interface Executor {

    <T> T query(String statement, Object parameter);

}
