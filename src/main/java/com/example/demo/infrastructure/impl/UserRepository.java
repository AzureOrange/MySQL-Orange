package com.example.demo.infrastructure.impl;

import com.example.demo.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 数据库访问
 *
 * @author orange
 * @Time 2017/11/29 0029
 */

public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 按条件查询
     *
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 按条件排序查询
     *
     * @param name
     * @param sort
     * @return
     */
    List<User> findByName(String name, Sort sort);

    /**
     * 按条件分页排序查询
     *
     * @param name
     * @param pageable
     * @return
     */
    List<User> findByName(String name, Pageable pageable);

    /**
     * 根据条件判断是否存在
     *
     * @param name
     * @return
     */
    Boolean existsByName(String name);

    Long countByName(String name);
}
