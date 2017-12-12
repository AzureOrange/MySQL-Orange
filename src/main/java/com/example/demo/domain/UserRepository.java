package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 数据库访问
 *
 * @author orange
 * @Time 2017/11/29 0029
 */

public interface UserRepository extends JpaRepository<User,Long> {

}
