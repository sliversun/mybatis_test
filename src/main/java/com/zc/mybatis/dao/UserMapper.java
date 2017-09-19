package com.zc.mybatis.dao;

import com.zc.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/*
*
* Mybatis注解测试   =====  有很多弊端，可扩展性差，无法完成 一对多 的映射
* */
@Mapper
public interface UserMapper {
    @Select("select * from m_user")
     List<User>  findUser();
}
