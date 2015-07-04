package com.levelup.spring.service;

import com.levelup.spring.dao.TeacherRepository;
import com.levelup.spring.model.Teacher;

import java.util.List;

/**
 * Created by denis_zavadsky on 3/5/15.
 */
public interface TeacherService {

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long id);

    public void setTeacherRepository(TeacherRepository teacherRepository);
}
