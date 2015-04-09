package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.TeacherRepository;
import com.levelup.spring.model.Student;
import com.levelup.spring.model.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by denis_zavadsky on 3/3/15.
 */
@Repository("teacherRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class TeacherRepositoryImpl implements TeacherRepository {

    private HashMap<Long, Teacher> teachersMap = new HashMap<>();


    @PersistenceContext
    private EntityManager entityManager;

   // @PostConstruct
    //@Transactional
    private void init(){
        Teacher teacher1 = new Teacher();
        //teacher1.setId(1L);
        teacher1.setFirstName("Ivan");
        teacher1.setLastName("Ivanov");
        teachersMap.put(1L, teacher1);
        entityManager.persist(teacher1);


        teacher1 = new Teacher();
       // teacher1.setId(2L);
        teacher1.setFirstName("Petr");
        teacher1.setLastName("Petrov");
        teachersMap.put(2L, teacher1);
        entityManager.persist(teacher1);

        teacher1 = new Teacher();
        //teacher1.setId(3L);
        teacher1.setFirstName("Sam");
        teacher1.setLastName("Neil");
        teachersMap.put(3L, teacher1);

        entityManager.persist(teacher1);

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Doe");

        entityManager.persist(student);
        List<Student> students = new ArrayList<Student>();
        students.add(student);

        teacher1.setStudents(students);
        entityManager.merge(teacher1);
    }

    @Override
   // @Transactional
    public List<Teacher> getAllTeachers() {
        init();
        List<Teacher> teachers = new ArrayList<>();

        teachers.addAll(teachersMap.values());
        return teachers;
    }

    public Teacher getTeacherById(Long id){
        return teachersMap.get(id);
    }
}
