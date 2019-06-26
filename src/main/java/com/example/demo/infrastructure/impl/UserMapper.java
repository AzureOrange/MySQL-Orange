package com.example.demo.infrastructure.impl;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * mybatis 访问数据库
 *
 * @author orange
 * @Time 2017/12/13 0013
 */
@Repository
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
