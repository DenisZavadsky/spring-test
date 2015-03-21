package com.levelup.spring.model.dto;

import com.levelup.spring.model.user.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by denis_zavadsky on 3/21/15.
 */
@XmlRootElement(name="users")
public class Users {

    private List<User> user;


    public List<User> getUsers() {
        return user;
    }

    @XmlElementWrapper(name = "userlist")
    @XmlElement(name = "user")
    public void setUsers(List<User> users) {
        this.user = users;
    }
}
