package com.levelup.spring.view;

import com.levelup.spring.model.dto.Users;
import com.levelup.spring.model.user.User;
import com.levelup.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denis_zavadsky on 3/17/15.
 */
@Controller
@RequestMapping("/index")
public class WelcomeController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("test","Test Attribute");
        return "welcome";
    }

    @RequestMapping(value = "/custom",method = RequestMethod.GET)
    public ModelAndView getCustomIndex(@RequestParam("name") String userName){
        ModelAndView result = new ModelAndView();
        result.addObject("userName",userName);
        result.setViewName("custom");
        return result;
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public @ResponseBody User getUser(){
        User user = new User();
        user.setId(1L);
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setAge(33);

        return user;
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET, produces = "application/xml")
    public @ResponseBody
    Users getUsers(){
        List<User> users = new ArrayList<>();
        Users result = new Users();
        User user = new User();
        user.setId(1L);
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setAge(33);

        users.add(user);

        user = new User();
        user.setId(2L);
        user.setFirstName("Egor");
        user.setLastName("Sidorov");
        user.setAge(20);

        users.add(user);

        result.setUsers(users);
        return result;
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Users getUsersJson(){
        List<User> users = new ArrayList<>();
        Users result = new Users();
        User user = new User();
        user.setId(1L);
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setAge(33);

        users.add(user);

        user = new User();
        user.setId(2L);
        user.setFirstName("Egor");
        user.setLastName("Sidorov");
        user.setAge(20);

        users.add(user);

        result.setUsers(users);
        return result;
    }
}
