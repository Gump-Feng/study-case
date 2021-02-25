package com.tutu.mybatis.session;

import com.tutu.mybatis.config.Function;
import com.tutu.mybatis.config.MapperBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/8/8$ 15:02$
 * @Version: 1.0
 */
public class MapperProxy implements InvocationHandler {

    private final SqlSession sqlSession;
    private final Configuration configuration;

    public MapperProxy(Configuration configuration, SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        this.configuration = configuration;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        MapperBean readMapper = configuration.readMapper("UserMapper.xml");
        //是否是xml文件对应的接口
        if(!method.getDeclaringClass().getName().equals(readMapper.getInterfaceName())){
            return null;
        }
        List<Function> list = readMapper.getList();
        if (list != null) {
            for (Function function : list) {
                //id是否和接口方法名一样
                if (method.getName().equals(function.getFuncName())) {
                    return sqlSession.selectOne(function.getSql(), String.valueOf(objects[0]));
                }
            }
        }
        return null;
    }
}
