package com.tutu.mybatis.config;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/8/8$ 15:00$
 * @Version: 1.0
 */
public class MapperBean {
    /**
     * 接口名
     */
    private String interfaceName;
    /**
     * 接口下所有方法
     */
    private List<Function> list;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public List<Function> getList() {
        return list;
    }

    public void setList(List<Function> list) {
        this.list = list;
    }
}
