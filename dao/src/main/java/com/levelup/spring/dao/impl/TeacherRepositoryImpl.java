package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.TeacherRepository;
import com.levelup.spring.model.Teacher;

import java.util.List;

/**
 * Created by denis_zavadsky on 3/3/15.
 */
public class TeacherRepositoryImpl implements TeacherRepository {

    @Override
    public List<Teacher> getAllTeachers() {
        System.out.println("Teachers loaded from repository");
        return null;
    }
}
