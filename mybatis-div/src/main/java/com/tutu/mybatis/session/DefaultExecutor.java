package com.tutu.mybatis.session;

import com.tutu.mybatis.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/8/8$ 15:02$
 * @Version: 1.0
 */
public class DefaultExecutor implements Executor {

    private final Configuration xmlConfiguration = new Configuration();

    @Override
    public <T> T query(String sql, Object parameter) {
        Connection connection = getConnection();
        ResultSet set = null;
        PreparedStatement pre = null;
        try {
            assert connection != null;
            pre = connection.prepareStatement(sql);
            //设置参数
            pre.setString(1, parameter.toString());
            set = pre.executeQuery();
            User u = new User();
            //遍历结果集
            while (set.next()) {
                u.setId(set.getString(1));
                u.setUsername(set.getString(2));
                u.setPassword(set.getString(3));
            }
            return (T) u;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (set != null) {
                    set.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private Connection getConnection() {
        try {
            return xmlConfiguration.build("mybatis-config.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
