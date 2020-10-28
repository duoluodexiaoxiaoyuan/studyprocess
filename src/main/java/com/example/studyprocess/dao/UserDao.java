package com.example.studyprocess.dao;

import com.example.studyprocess.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    //通过用户名查询到数据库的User表
    User findByName(String name);

    void save(User user);

    List<User>  findAll();


}
