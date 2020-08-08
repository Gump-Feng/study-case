package com.ertu.mybatis.session;

import java.lang.reflect.Proxy;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/8/8$ 15:01$
 * @Version: 1.0
 */
public class SqlSession {

    private Executor executor= new DefaultExecutor();

    private Configuration myConfiguration = new Configuration();

    public <T> T selectOne(String statement,Object parameter){
        return executor.query(statement, parameter);
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> clazz){
        //动态代理调用
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},
                new MapperProxy(myConfiguration,this));
    }

}
