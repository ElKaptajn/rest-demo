package com.example.restdemo.controller;

import com.example.restdemo.model.Course;
import com.example.restdemo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("course")
public class CourseController {

    private CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<Set<Course>> getCourses() { // returns data as JSON
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseDetails(@PathVariable Long courseId) { // returns data as JSON
        return new ResponseEntity<>(courseService.findById(courseId).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Set<Course>> addCourse(@RequestBody Course course) { // returns data as JSON
        courseService.save(course);
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public String deleteCourse(@PathVariable("courseId") Long courseId){
        courseService.deleteById(courseId);
        return "user with id: " + courseId + " have been deleted";
    }

}