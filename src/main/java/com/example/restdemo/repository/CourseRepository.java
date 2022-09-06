
package com.example.restdemo.repository;

import com.example.restdemo.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
