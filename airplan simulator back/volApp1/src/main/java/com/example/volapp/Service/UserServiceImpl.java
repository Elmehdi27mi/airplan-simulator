package com.example.volapp.Service;

import com.example.volapp.Entity.User;
import com.example.volapp.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao ;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(User user) {
         List<User> users =userDao.findAll();
        for (User tempUser:users) {
            if (Objects.equals(tempUser.getUsername(), user.getUsername())&&
                    Objects.equals(tempUser.getPassword(), user.getPassword())
            ){
                return tempUser ;
            }
        }
        return null ;
    }


}
