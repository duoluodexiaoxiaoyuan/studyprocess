package com.example.studyprocess.controller;

import com.example.studyprocess.entity.User;
import com.example.studyprocess.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user){
        User login = userService.login(user);
        return "redirect:/user/findAll";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public String register(User user){
        userService.register(user);
        return "注册成功";
    }

//    @RequestMapping("findAll")
//    @ResponseBody
//    public List<User> findAll(){
//        List<User> users=userService.findAll();
////        model.addAttribute("users",users);
//        return users;
//    }

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "index.jsp";
    }


}
