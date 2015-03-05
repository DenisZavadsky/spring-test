package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.TeacherRepository;
import com.levelup.spring.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by denis_zavadsky on 3/5/15.
 */
@Repository("teacherRepositoryTest")
public class TeacherRepositoryTest implements TeacherRepository{


    @Override
    public List<Teacher> getAllTeachers() {
        return null;
    }
}
