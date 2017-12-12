package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 逻辑层
 *
 * @author orange
 * @Time 2017/11/29 0029
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void save(){
        User user = new User();
        user.createUserCase();

        userRepository.save(user);

        System.out.println("user的主键---->" + user.toString());
    }
}
