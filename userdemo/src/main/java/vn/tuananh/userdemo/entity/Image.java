package vn.tuananh.userdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private int id;
    private String uploadedAt;
    private Data data;
    private int userId;
}
