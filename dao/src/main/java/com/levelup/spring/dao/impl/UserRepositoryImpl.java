package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.UserRepository;
import com.levelup.spring.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by denis_zavadsky on 3/14/15.
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert jdbcInsertUser;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcInsertUser = new SimpleJdbcInsert(dataSource).withTableName("USER").usingGeneratedKeyColumns("id");
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createUser(User user) {
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
        Number userId = jdbcInsertUser.executeAndReturnKey(namedParameters);
        user.setId(userId.longValue());
    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM USER where id=:pid";
        Map<String,String> parameterMap = new HashMap<>();
        parameterMap.put("pid",id.toString());
        User user = namedParameterJdbcTemplate.queryForObject(sql,parameterMap, new BeanPropertyRowMapper<User>(User.class));
        return user;
    }

    @Override
    public User getUserByName(String firstName, String lastName) {
        String sql = "SELECT * FROM USER where firstName=:firstName AND lastName=:lastName";
        Map<String,String> parameterMap = new HashMap<>();
        parameterMap.put("firstName",firstName);
        parameterMap.put("lastName",lastName);
        SqlParameterSource namedParameters = new MapSqlParameterSource(parameterMap);

        User user = namedParameterJdbcTemplate.queryForObject(sql,namedParameters, new BeanPropertyRowMapper<User>(User.class));
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
