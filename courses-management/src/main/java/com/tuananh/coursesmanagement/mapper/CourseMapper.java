package com.tuananh.coursesmanagement.mapper;

import com.tuananh.coursesmanagement.dto.CourseRecord;
import com.tuananh.coursesmanagement.entity.Course;
import com.tuananh.coursesmanagement.entity.User;

public class CourseMapper {
    public static CourseRecord toCourseRecord(Course course, User user) {
        return new CourseRecord(course.getId(), course.getName(), course.getDescription(), course.getType(), course.getTopics(), course.getThumbnail(), user);
    }
}
