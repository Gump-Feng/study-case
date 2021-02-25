package com.tutu.mybatis.mapper;

import com.tutu.mybatis.bean.User;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/8/8$ 14:47$
 * @Version: 1.0
 */
public interface UserMapper {

    User getUserById(int id);
}
