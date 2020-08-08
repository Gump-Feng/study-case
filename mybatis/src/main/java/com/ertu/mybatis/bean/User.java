package com.ertu.mybatis.bean;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/8/8$ 14:45$
 * @Version: 1.0
 */
public class User {

    private String id;
    private String username;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
