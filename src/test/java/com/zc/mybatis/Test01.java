package com.zc.mybatis;

import com.zc.mybatis.dao.UserMapper;
import com.zc.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Test01 {
    //    测试Mapper.xml连接方式
    @Test
    public void connTest() {
        InputStream is = Test01.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSession session = new SqlSessionFactoryBuilder() build(is).openSession(true);
        //Mapper.xml执行方式
        String statement = "com.zc.mybatis.entity.User.select";
        List<User> list = session.selectList(statement);
        for (User u : list) {
            System.out.println(u);
        }
    }

    //    测试接口注解方式
    @Test
    public void annotionTest() {
        InputStream is = Test01.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSession session = new SqlSessionFactoryBuilder().build(is).openSession(true);
        // 接口注解获取
        UserMapper userDao = session.getMapper(UserMapper.class);
        List<User> list = userDao.findUser();
        for (User u : list) {
            System.out.println(u);
        }
    }
}
