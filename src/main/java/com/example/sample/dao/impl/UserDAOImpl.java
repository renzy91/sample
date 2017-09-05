package com.example.sample.dao.impl;
import com.example.sample.dao.UserDAO;
import com.example.sample.dao.mapper.UserMapper;
import com.example.sample.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/9/5 16:26
 */
@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
       userMapper.insertSelective(user);
    }
}
