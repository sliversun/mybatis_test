package com.zc.mybatis.dao;

import com.zc.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
/*
*
* Mybatis注解测试   =====  有很多弊端:1.可扩展性差，无法完成 一对多 的映射
*                                      2.不支持mybatis动态语言书写
* */
@Mapper
public interface UserMapper {
    @Select("select * from m_user")
     List<User>  findUser();
    @Update(" update m_user set name = #{name}, age = #{age} where id = #{id}")
     void update（User user）;
    @Insert("insert into  m_user(id,name,age)  values(#{id},#{name},#{age})")
     void add(User user);
    @Delete("delete from m_user WHERE id = #{id}")
     void delete(int  id);
}
