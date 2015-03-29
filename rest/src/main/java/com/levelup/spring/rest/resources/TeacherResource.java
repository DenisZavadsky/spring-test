package com.levelup.spring.rest.resources;

import com.levelup.spring.model.Teacher;
import com.levelup.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by denis_zavadsky on 3/29/15.
 */
@Path("/teacher")
@Component
public class TeacherResource {

    //@Autowired
    private TeacherService teacherService;

    @Context ServletContext context;


    private void initContext(){
        if (teacherService == null) {
            WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
            teacherService = (TeacherService) applicationContext.getBean("teacherService");
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> getAllTeachers(){
        initContext();
        List<Teacher> result = teacherService.getAllTeachers();
        return result;
    }

    @Path("/get/{teacherId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Teacher getTeacherById(@PathParam("teacherId") Long teacherId){
        initContext();
        Teacher result = teacherService.getTeacherById(teacherId);
        return result;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Teacher createTeacher(@QueryParam("id") Long id,
                                 @QueryParam("firstName") String firstName,
                                 @QueryParam("lastName") String lastName){
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        return teacher;
    }
}
