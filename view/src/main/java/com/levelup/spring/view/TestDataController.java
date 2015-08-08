package com.levelup.spring.view;

import com.levelup.spring.dto.UserData;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by denis_zavadsky on 5/28/15.
 */
@Controller
@RequestMapping("/test")
public class TestDataController {

    @RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserData getData(){
        UserData userData = new UserData();
        userData.setFirstName("Ivan");
        userData.setLastName("Ivanov");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDate = dateFormat.format(new Date());
        userData.setDate(currentDate);
        return userData;

    }

    @RequestMapping(value = "/data/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<UserData> getDataById(@PathVariable("id") Long id){
        List<UserData> result = new ArrayList<>();
        UserData userData = new UserData();
        userData.setId(id);
        userData.setFirstName("Ivan");
        userData.setLastName("Ivanov");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDate = dateFormat.format(new Date());
        userData.setDate(currentDate);

        result.add(userData);

        userData = new UserData();
        userData.setId(id);
        userData.setFirstName("Stepan");
        userData.setLastName("Petrov");

        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        currentDate = dateFormat.format(new Date());
        userData.setDate(currentDate);

        result.add(userData);
        return result;

    }

}
