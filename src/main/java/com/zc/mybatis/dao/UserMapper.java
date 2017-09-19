package com.zc.mybatis.dao;

import com.zc.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from m_user")
     List<User>  findUser();
}
