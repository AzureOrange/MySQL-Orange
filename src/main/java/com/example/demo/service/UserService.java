package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.infrastructure.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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

    public void findAll(){
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

        User user2 = new User();
        user2.createUserCase();
        user2.setUpdateTime(1513131428573L);
        user2.setId(6L);
        Example<User> example = Example.of(user2);
        User user1 = userRepository.findOne(example);
        System.out.println("输出user1--->" + user1.toString());
    }

    public void findByCondition(){
        String name = "张三22";

        List<User> userList = userRepository.findByName(name, new Sort(Sort.Direction.ASC,"updateTime"));

        userList.forEach(o1 -> {
            System.out.println("user的内容---->" + o1.toString() + "\n");
        });
    }

    public void exists(){
        String name = "张三224";

        boolean flag = userRepository.existsByName(name);

        System.out.println("输出--->" + flag);
    }

    @PostConstruct
    public void count(){
        String name = "张三22";

        long total = userRepository.count();
        long count = userRepository.countByName(name);
        System.out.println("输出--->" + total + "\n --->" + count );



    }
}
