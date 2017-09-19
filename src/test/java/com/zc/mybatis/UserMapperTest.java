package com.zc.mybatis;

import com.zc.mybatis.dao.UserMapper;
import com.zc.mybatis.entity.User;
import com.zc.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class Test01 extends SuperTest {
    //    测试Mapper.xml连接方式
    @Test
    public void connTest() {
        InputStream is = Test01.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSession session = new SqlSessionFactoryBuilder().build(is).openSession(true);
        //Mapper.xml执行方式
        String statement = "com.zc.mybatis.entity.User.list";
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

    @Test
    public void addTest() {
        SqlSession session = MybatisUtil.getSession();
        User User = new User(new BigDecimal(1002), "张三", "89");
        String statement = "com.zc.mybatis.entity.User.add";
        int count = session.insert(statement, User);
        log.info("插入结果:" + count);
    }

    @Test
    public void updateTest() {
        SqlSession session = MybatisUtil.getSession();
        User user = new User(new BigDecimal(1002), "李四", "10");
        String statement = "com.zc.mybatis.entity.User.update";
        int count = session.update(statement, user);
        log.info("更新结果:" + count);
    }
    @Test
    public void deleteTest() {
        SqlSession session = MybatisUtil.getSession();
        User user = new User(new BigDecimal(1002), "", "");
        String statement = "com.zc.mybatis.entity.User.delete";
        int count = session.delete(statement, user);
        log.info("删除结果:" + count);
    }
}