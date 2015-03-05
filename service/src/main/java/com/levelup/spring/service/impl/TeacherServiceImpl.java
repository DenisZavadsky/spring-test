package com.levelup.spring.service.impl;

import com.levelup.spring.dao.TeacherRepository;
import com.levelup.spring.model.Teacher;
import com.levelup.spring.service.TeacherService;

import java.util.List;

/**
 * Created by denis_zavadsky on 3/5/15.
 */
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherServiceImpl() {
    }

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {

        return teacherRepository.getAllTeachers();
    }
}
