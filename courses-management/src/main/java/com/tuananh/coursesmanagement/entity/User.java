package com.tuananh.coursesmanagement.entity;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id ;
    @NotNull(message = "Tên không được để trống")
    private String name ;

    @NotNull(message = "Email không được để trống")
    private String email ;

    @NotNull(message = "SĐT không được để trống")
    private String phone ;


    private String avatar ;

}
