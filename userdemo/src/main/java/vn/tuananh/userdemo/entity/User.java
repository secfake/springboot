package vn.tuananh.userdemo.entity;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    private int id;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String avatar;

    private String password;
}
