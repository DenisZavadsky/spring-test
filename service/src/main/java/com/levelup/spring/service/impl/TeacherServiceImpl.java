package com.levelup.spring.service.impl;

import com.levelup.spring.dao.TeacherRepository;
import com.levelup.spring.model.Teacher;
import com.levelup.spring.service.TeacherService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by denis_zavadsky on 3/5/15.
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware,
        InitializingBean, DisposableBean{

    private ApplicationContext context;
    private ClassLoader classLoader;
    private String beanName;

    @Resource(name = "teacherRepositoryTest")
//    @Inject
//    @Named("teacherRepositoryTest")
    //@Autowired
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        System.out.println("ApplicationContext aware");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        System.out.println("ClassLoader aware");
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
        System.out.println("BeanName aware");
    }

    @PostConstruct
    public void init1(){
        System.out.println("PostConstruct called");
    }


    public void init2(){
        System.out.println("XML init-method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean method called");
    }

    @PreDestroy
    public void destroy1(){
        System.out.println("PreDestroy called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Disposable Bean method called");
    }

    public void destroy2(){
        System.out.println("XML destroy-method called");
    }

}
