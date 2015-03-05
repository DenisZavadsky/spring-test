package com.levelup.spring.service.impl;

import com.levelup.spring.dao.TeacherRepository;
import com.levelup.spring.model.Teacher;
import com.levelup.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by denis_zavadsky on 3/5/15.
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    //@Resource(name = "teacherRepositoryTest")
    @Inject
    @Named("teacherRepositoryTest")
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
