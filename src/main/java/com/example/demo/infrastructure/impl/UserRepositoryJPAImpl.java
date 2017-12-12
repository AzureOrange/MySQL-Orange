package com.example.demo.infrastructure.impl;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * descript
 *
 * @author orange
 * @Time 2017/12/12 0012
 */
public class UserRepositoryJPAImpl {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    public void store(User user){
        userRepositoryJPA.save(user);
    }
}
