package com.example.sample.service.impl;

import com.example.sample.dao.UserDAO;
import com.example.sample.database.User;
import com.example.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/9/5 16:35
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void insertUser(User user) {
        userDAO.insertUser(user);
        throw new RuntimeException();
    }
}
