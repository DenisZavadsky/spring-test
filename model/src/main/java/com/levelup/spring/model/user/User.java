package com.levelup.spring.model.user;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by denis_zavadsky on 3/14/15.
 */

@XmlRootElement(name = "user")
public class User implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    public User() {
    }

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlAttribute
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlAttribute
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    @XmlAttribute
    public void setAge(Integer age) {
        this.age = age;
    }
}
