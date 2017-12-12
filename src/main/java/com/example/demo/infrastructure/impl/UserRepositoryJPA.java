package com.example.demo.infrastructure.impl;

import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * spring JPA
 *
 * @author orange
 * @Time 2017/11/29 0029
 */
public interface UserRepositoryJPA extends CrudRepository<User,Long> {
}
