package com.example.restdemo.service.impl;

import com.example.restdemo.model.Course;
import com.example.restdemo.repository.CourseRepository;
import com.example.restdemo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public Set<Course> findAll(){
        Set<Course> set = new HashSet<>();
        courseRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Course save(Course object) {

        return courseRepository.save(object);
    }

    @Override
    public void delete(Course object) {
    }

    @Override
    public void deleteById(Long aLong) {
    }

    @Override
    public Optional<Course> findById(Long aLong) {
        return Optional.empty();
    }

}
