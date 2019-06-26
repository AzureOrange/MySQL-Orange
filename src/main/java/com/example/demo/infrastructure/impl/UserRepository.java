package com.example.demo.infrastructure.impl;

import com.example.demo.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 数据库访问
 *
 * @author orange
 * @Time 2017/11/29 0029
 */

public interface UserRepository extends JpaRepository<User, Long> {

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

    /**
     * 根据条件统计
     *
     * @param name
     * @return
     */
    Long countByName(String name);

    /**
     * 按条件删除
     *
     * @param name
     * @return
     */
    long deleteByName(String name);


    /**
     * 按条件更新
     *
     * @param name
     * @param id
     */
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name = ?1 WHERE u.id = ?2")
    void updateName(String name, long id);
}
