package com.example.restdemo.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="course_information")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<User> enrolledUsers = new HashSet<>();

    @Column
    private String name;
    @Column
    private Date startDate;

    /**
    @OneToMany(mappedBy = "course")
    private Set<User> userList;
    */

    public Course(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public Course() {

    }

    public void setEnrolledUsers(Set<User> enrolledUsers) {
        this.enrolledUsers = enrolledUsers;
    }

    public Set<User> getEnrolledUsers() {
        return enrolledUsers;
    }

    /**
    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }
*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void enrollUser (User user){
        enrolledUsers.add(user);
    }

}
