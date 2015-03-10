package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.TeacherRepository;
import com.levelup.spring.dao.mapper.TeacherRowMapper;
import com.levelup.spring.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by denis_zavadsky on 3/5/15.
 */
@Repository("teacherRepositoryTest")
public class TeacherRepositoryTest implements TeacherRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    private DataSource dataSource;
//
//    public DataSource getDataSource() {
//        return dataSource;
//    }

//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    @Override
    public List<Teacher> getAllTeachers() {

        Integer teachersCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Teacher", Integer.class);
        List<Integer> teachersId = jdbcTemplate.queryForList("SELECT id from Teacher",Integer.class);

        List<Teacher> teachers = jdbcTemplate.query("SELECT * FROM Teacher", new TeacherRowMapper());
        return null;
    }

    public Teacher getTeacherByName(String firstName, String lastName){

        List<Teacher> teachers = jdbcTemplate.query("SELECT * FROM Teacher WHERE firstName = ? AND lastName = ?",
                new Object[]{firstName,lastName},new TeacherRowMapper());

        return  teachers.get(0);
    }

    public void deleteTeacherById(Long id){
        jdbcTemplate.update("delete from Teacher where id = ?", id);
    }
}
