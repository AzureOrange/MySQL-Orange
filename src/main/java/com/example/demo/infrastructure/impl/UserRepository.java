package com.example.demo.infrastructure.impl;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 数据库访问
 *
 * @author orange
 * @Time 2017/11/29 0029
 */

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByName(String name);
}
