package com.levelup.spring.dao.mapper;

import com.levelup.spring.model.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by denis_zavadsky on 3/10/15.
 */
public class TeacherRowMapper implements RowMapper<Teacher> {

    @Override
    public Teacher mapRow(ResultSet resultSet, int i) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setId(resultSet.getLong("ID"));
        teacher.setFirstName(resultSet.getString("firstName"));
        teacher.setLastName(resultSet.getString("lastName"));
        return teacher;
    }
}
