package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.infrastructure.impl.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * descript
 *
 * @author orange
 * @Time 2017/12/13 0013
 */
@Service
public class UserMapperService {

    @Autowired
    private UserMapper userMapper;

    @PostConstruct
    public void find(){
        String name = "666";

        User user = userMapper.findByName(name);

        System.out.println("name的内容---->" + user.toString());
    }
}
