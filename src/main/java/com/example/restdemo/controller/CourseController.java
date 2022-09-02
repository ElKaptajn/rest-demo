/*
package com.example.restdemo.controller;

import com.example.restdemo.model.Course;
import com.example.restdemo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<Set<Course>> getCourses() { // returns data as JSON
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Set<Course>> addCourse(Course course) { // returns data as JSON
        courseService.save(course);
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCourse")
    public ResponseEntity<Set<Course>> deleteCourse(Long courseId){
        courseService.deleteById(courseId);
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

}
*/