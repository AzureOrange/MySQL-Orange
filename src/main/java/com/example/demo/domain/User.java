package com.example.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户
 *
 * @author orange
 * @Time 2017/11/27 0027
 * <pre>根据开闭原则，set方法理论上不应该对外开放</pre>
 * <pre>方法的权限要严谨，限制</pre>
 */
@Entity
@Table
public class User {

    /**
     * 主键
     *
     * <pre>TABLE：使用一个特定的数据库表格来保存主键。 </pre>
     * <pre>SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。</pre>
     * <pre>IDENTITY：主键由数据库自动生成（主要是自动增长型） </pre>
     * <pre>AUTO：主键由程序控制。 </pre>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 姓名
     */
    @Column(nullable = false, length = 20)
    private String name;

    /**
     * 年纪
     */
    @Column(nullable = false, length = 10)
    private int age;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Long updateTime;

    /**
     * 体型
     */
    @Embedded
    @Column(name = "bodyBuild")
    private BodyBuild bodyBuild;

    /**
     * 学校
     */
    @Embedded
    @Column(name = "schools")
    private List<School> schools;

    /**
     * 地址
     */
    @Embedded
    @Column(name = "address")
    private List<String> address;


    /**
     * 创建一个实例
     */
    public void createUserCase() {
        this.name = "张三22";
        this.age = 122;
        this.updateTime = System.currentTimeMillis();

        List<String> address = new ArrayList<>();
        address.add("杭州");
        address.add("上海");
        this.address = address;

        BodyBuild bodyBuild = new BodyBuild(333, 222, "A");
        this.bodyBuild = bodyBuild;

        List<School> schoolList = new ArrayList<>();
        schoolList.add(new School(111, "学校名称", 2015));
        schoolList.add(new School(1123, "学校名称--2", 2016));
        this.schools = schoolList;
    }

    public User() {
    }

    public User(String name, int age, Long updateTime, BodyBuild bodyBuild, List<School> schools, List<String> address) {
        this.name = name;
        this.age = age;
        this.updateTime = updateTime;
        this.bodyBuild = bodyBuild;
        this.schools = schools;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public BodyBuild getBodyBuild() {
        return bodyBuild;
    }

    public void setBodyBuild(BodyBuild bodyBuild) {
        this.bodyBuild = bodyBuild;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }


}
