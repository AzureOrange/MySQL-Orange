package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.infrastructure.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

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

    public void save(){
        User user = new User();
        user.createUserCase();

        userRepository.save(user);

        System.out.println("user的内容---->" + user.toString());
    }

    @PostConstruct
    public void find(){
        User user = userRepository.findOne(1L);

        List<User> userList = userRepository.findAll();

        List<User> userSortList = userRepository.findAll(new Sort(Sort.Direction.ASC,"updateTime"));

        Page<User> userPageList = userRepository.findAll(new PageRequest(0,2, Sort.Direction.DESC,"updateTime"));

        List<User> users = userPageList.getContent(); //内容
        int totalPages = userPageList.getTotalPages(); // 页数
        long totalElements = userPageList.getTotalElements(); // 总数


        users.forEach(o1 -> {
            System.out.println("user的内容---->" + o1.toString() + "\n");
        });
        System.out.println("页数--->" + totalPages + "\n总条数--->" + totalElements);

    }
}
