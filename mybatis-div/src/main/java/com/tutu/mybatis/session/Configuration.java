package com.tutu.mybatis.session;

import com.tutu.mybatis.config.Function;
import com.tutu.mybatis.config.MapperBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: 读取解析配置信息，返回mybatis配置文件对应的实体类
 * @Author: hxf
 * @CreateDate: 2020/8/8$ 14:54$
 * @Version: 1.0
 */
public class Configuration {
    private static final ClassLoader classLoader = ClassLoader.getSystemClassLoader();

    public Connection build(String resource) {
        try {
            InputStream stream = classLoader.getResourceAsStream(resource);
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element root = document.getRootElement();
            return evalDataSource(root);
        } catch (Exception e) {
            throw new RuntimeException("error occured while evaling xml " + resource);
        }
    }

    private Connection evalDataSource(Element node) {
        if (!"database".equals(node.getName())) {
            throw new RuntimeException("root should be <database>");
        }
        String driverClassName = null;
        String url = null;
        String username = null;
        String password = null;
        //获取属性节点
        for (Object item : node.elements("property")) {
            Element i = (Element) item;
            String value = getValue(i);
            String name = i.attributeValue("name");
            if (name == null || value == null) {
                throw new RuntimeException("[database]: <property> should contain name and value");
            }
            //赋值
            switch (name) {
                case "url":
                    url = value;
                    break;
                case "username":
                    username = value;
                    break;
                case "password":
                    password = value;
                    break;
                case "driverClassName":
                    driverClassName = value;
                    break;
                default:
                    throw new RuntimeException("[database]: <property> unknown name");
            }
        }

        Connection connection = null;
        try {
            Class.forName(driverClassName);
            //建立数据库链接
            assert url != null;
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    private String getValue(Element node) {
        return node.hasContent() ? node.getText() : node.attributeValue("value");
    }

    public MapperBean readMapper(String path){
        MapperBean mapper = new MapperBean();
        try{
            InputStream stream = classLoader.getResourceAsStream(path);
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element root = document.getRootElement();
            //把mapper节点的nameSpace值存为接口名
            mapper.setInterfaceName(root.attributeValue("nameSpace").trim());
            //用来存储方法的List
            List<Function> list = new ArrayList<Function>();
            //遍历根节点下所有子节点
            for(Iterator rootIter = root.elementIterator(); rootIter.hasNext();) {
                //用来存储一条方法的信息
                Function fun = new Function();
                Element e = (Element) rootIter.next();
                String sqlType = e.getName().trim();
                String funcName = e.attributeValue("id").trim();
                String sql = e.getText().trim();
                String resultType = e.attributeValue("resultType").trim();
                fun.setSqlType(sqlType);
                fun.setFuncName(funcName);
                Object newInstance=null;
                try {
                    newInstance = Class.forName(resultType).newInstance();
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                fun.setResultType(newInstance);
                fun.setSql(sql);
                list.add(fun);
            }
            mapper.setList(list);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return mapper;
    }

}
