package com.tuananh.coursesmanagement.repository;

import com.tuananh.coursesmanagement.entity.Course;
import com.tuananh.coursesmanagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDB {

       public static ArrayList<User> users = new ArrayList <>(List.of(
                new User(1, "tuan anh", "tuananh@gmail.com", "0985457125", ""),
                new User(2, "hung", "hung@gmail.com", "0985457125", ""),
                new User(3, "nam", "nam@gmail.com", "0985457125", "")
        ));
       public static ArrayList<Course> courses = new ArrayList <>(List.of(
                new Course(1, "khóa học 1", "mô tả", "online", null, "", 1),
                new Course(2, "khóa học 2", "mô tả", "online", null, "", 2),
                new Course(3, "khóa học 2", "mô tả", "offline", null, "", 3)
        ));
    }

