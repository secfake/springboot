package com.tuananh.coursesmanagement.controller;

import com.tuananh.coursesmanagement.entity.Course;

import com.tuananh.coursesmanagement.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private CourseService courseService;

//    @GetMapping("/api/v1/courses")
//    public List<Course> getCourses(@RequestParam(required = false) String type,
//                                   @RequestParam(required = false) String name,
//                                   @RequestParam(required = false) String topic) {
//        // Your code here
//    }

    @GetMapping("/api/v1/courses/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        return ResponseEntity.ok().body(courseService.getCourse(id));
    }
}
