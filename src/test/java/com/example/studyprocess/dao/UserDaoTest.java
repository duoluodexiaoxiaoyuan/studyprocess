package com.example.studyprocess.dao;

import com.example.studyprocess.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    void findByName() {
        User zhangsan = userDao.findByName("zhangsan");
        System.out.println(zhangsan);
    }
    @Test
    void save(){
        User user=new User();
        user.setUsername("zhangsanfeng");
        user.setPassword("123");
        userDao.save(user);
    }
}