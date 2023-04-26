package com.tuananh.coursesmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int id; // Id khó a học
    private String name; // Tên khóa học
    private String description ; // Mô tả khóa học
    private String type; // Hình thức học (chỉ có 2 hình thức online/onlab)
    private List<String> topics; // danh sách các topic của khóa học (Ví dụ : frontend, backend, database, devops, basic, mobile, ...)
    private String thumbnail; // Ảnh khóa học
    private int userId; // Id người tư vấn khóa học

}
