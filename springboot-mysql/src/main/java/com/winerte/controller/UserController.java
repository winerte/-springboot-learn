package com.winerte.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.winerte.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private DataSource dataSource;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") String id) throws Exception {
        //打印传入的id
        System.out.println(id);
        Connection connection = dataSource.getConnection();
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        //打印连接池最大数量
        System.out.println(druidDataSource.getMaxActive());
        String sql = "select * from user where id= ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        System.out.println(user);
        druidDataSource.close();
        connection.close();
        return user;
    }

    @GetMapping("/test")
    private String test() {
        return "test";
    }
}
