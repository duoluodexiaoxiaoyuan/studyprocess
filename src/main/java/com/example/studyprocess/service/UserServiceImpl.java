package com.example.studyprocess.service;

import com.alibaba.druid.util.StringUtils;
import com.example.studyprocess.dao.UserDao;
import com.example.studyprocess.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User login(User user) {
        //返回数据库的内容
        User userDB = userDao.findByName(user.getUsername());
        if(userDB!=null){
            if(StringUtils.equals(userDB.getPassword(),user.getPassword())){
                System.out.println("用户名输出成功");
                return userDB;
            }
            throw new RuntimeException("密码输入错误~~");
        }
        throw new RuntimeException("用户名输入错误~~");


    }

    @Override
    public void register(User user) {
        User userDB = userDao.findByName(user.getUsername());
        if (userDB!=null){
            throw new RuntimeException("当前用户名已经被注册，请稍后再试");
        }
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


}
