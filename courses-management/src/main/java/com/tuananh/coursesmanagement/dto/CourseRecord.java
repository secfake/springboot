package com.tuananh.coursesmanagement.dto;

import com.tuananh.coursesmanagement.entity.User;


import java.util.List;

public record CourseRecord(int id,
                           String name,
                           String description,
                           String type,
                           List<String> topics,
                           String thumbnail,
                           User userId) {
}
