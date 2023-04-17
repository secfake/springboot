package vn.tuananh.products.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private  int id;
    private String name;
    private int price ;
    private String brand;
    private  int count ;
}
