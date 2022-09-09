package com.example.restdemo.controller;

import com.example.restdemo.model.Course;
import com.example.restdemo.model.User;
import com.example.restdemo.service.CourseService;
import com.example.restdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enroll")
public class EnrollController {

    private UserService userService;
    private CourseService courseService;

    public EnrollController(UserService userService, CourseService courseService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    /**
     * Enroll user in course
     * */
    @PutMapping("/{courseId}/user/{userId}")
    public Course enrollUserToCourse(@PathVariable Long courseId, @PathVariable Long userId){
        //Henter user og course ind for at vi kan arbejde med dem
        Course course = courseService.findById(courseId).get();
        User user = userService.getUser(userId);
        //Tjekker om user allerede har en Course tilknyttet
        if(user.getCourse() == null) {
            user.addCourse(course);
            course.enrollUser(user);
        }else {
            return courseService.save(course);
        }
        return courseService.save(course);
    }

    /**
     * Remove user from course
     * */
    @PutMapping("/removeUser/{courseId}/user/{userId}")
    public Course removeUserFromCourse(@PathVariable Long courseId, @PathVariable Long userId){
        //Henter user og course ind for at vi kan arbejde med dem
        Course course = courseService.findById(courseId).get();
        User user = userService.getUser(userId);
        //Tjekker om user er enrolled i course
        if(user.getCourse().getId() == courseId){
            course.getEnrolledUsers().remove(user);
            user.setCourse(null);
        }
        //Gemmer ændringerne i databasen
        userService.updateUser(user);
        return courseService.save(course);
    }
}
