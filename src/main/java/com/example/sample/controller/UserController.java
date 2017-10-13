package com.example.sample.controller;

import com.example.sample.database.User;
import com.example.sample.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/9/5 16:38
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "用户相关接口", position = 0)
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * transactional
     * @param user
     */

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert(User user) {
       userService.insertUser(user);
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public User select(String id) {
        User user = new User();
        user.setId(111);
        user.setAge(222);
        user.setName("333");
        return new User();
    }

}
