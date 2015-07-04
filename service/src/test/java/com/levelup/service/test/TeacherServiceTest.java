package com.levelup.service.test;

import com.levelup.spring.dao.*;
import com.levelup.spring.model.Teacher;
import com.levelup.spring.service.TeacherService;
import com.levelup.spring.service.impl.TeacherServiceImpl;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by denis_zavadsky on 6/30/15.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("classpath:test-service.xml")
public class TeacherServiceTest {

    private Mockery context;
    List<Teacher> teacherList = Arrays.asList(new Teacher());
    private IMocksControl control = EasyMock.createControl();

    @Mock
    private TeacherRepository teacherRepository;

//    @Mock
//    private CategoryRepository categoryRepository;
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @Mock
//    private TransactionRepository transactionRepository;
//
//    @Mock
//    private UserRepository userRepository;

    @InjectMocks
    @Autowired
    private TeacherServiceImpl teacherService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


//    @Before
//    public void initMockContext(){
//        context = new JUnit4Mockery();
//    }

    //@Test
    public void getAllTeachersTest(){
        TeacherService teacherService = new TeacherServiceImpl();

        final TeacherRepository teacherRepository = context.mock(TeacherRepository.class);

        context.checking(new Expectations(){{
            oneOf(teacherRepository).getAllTeachers();
            will(returnValue(teacherList));
        }});

        teacherService.setTeacherRepository(teacherRepository);
        List<Teacher> result = teacherService.getAllTeachers();

        context.assertIsSatisfied();
    }

   // @Test
    public void getTeacherByIdTest(){
        TeacherService teacherService = new TeacherServiceImpl();
        final TeacherRepository teacherRepository = control.createMock(TeacherRepository.class);

        EasyMock.expect(teacherRepository.getTeacherById(EasyMock.anyLong())).andReturn(new Teacher());

        control.replay();
        teacherService.setTeacherRepository(teacherRepository);
        Teacher teacher = teacherService.getTeacherById(2L);
        control.verify();

    }

    @Test
    public void getTeacherByIdTestMockito(){
        Teacher source = new Teacher();
        when(teacherRepository.getTeacherById(any(Long.class))).thenReturn(source);
        Teacher teacher = teacherService.getTeacherById(2L);

        Assert.assertEquals(teacher, source);

    }

}
