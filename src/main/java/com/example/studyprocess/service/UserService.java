package com.example.studyprocess.service;

import com.example.studyprocess.entity.User;

import java.util.List;

public interface UserService {

    User login(User user);

    void register(User user);

    List<User>  findAll();


}
