package com.example.demo.infrastructure.impl;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * spring JPA
 *
 * @author orange
 * @Time 2017/11/29 0029
 */
@Repository
public interface UserRepositoryJPA extends JpaRepository<User,Long>, UserRepository, JpaSpecificationExecutor {
}
