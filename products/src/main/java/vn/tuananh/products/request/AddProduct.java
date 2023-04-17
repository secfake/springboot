package vn.tuananh.products.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProduct {
    private String name;
    private int price ;
    private String brand;
    private  int count ;
}
