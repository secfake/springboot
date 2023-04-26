package com.tuananh.coursesmanagement.service;

import com.tuananh.coursesmanagement.dto.CourseRecord;
import com.tuananh.coursesmanagement.entity.Course;
import com.tuananh.coursesmanagement.entity.User;
import com.tuananh.coursesmanagement.mapper.CourseMapper;
import com.tuananh.coursesmanagement.repository.CourseDB;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Override
    public CourseRecord getCourse(int id) {

        for (Course course : CourseDB.courses) {
            if (course.getId() == id) {
                for (User user : CourseDB.users) {
                    if (user.getId() == course.getUserId()) {
                        return CourseMapper.toCourseRecord(course, user);
                    }
                }
            }
        }
        return null;
    }
}
