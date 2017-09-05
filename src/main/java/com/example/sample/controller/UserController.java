package com.example.sample.controller;

import com.example.sample.database.User;
import com.example.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/9/5 16:38
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * transactional
     * @param user
     */
    @RequestMapping("/insert")
    public void insert(User user) {
       userService.insertUser(user);
    }

}
