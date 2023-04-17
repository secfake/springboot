package vn.tuananh.products.mapper;

import vn.tuananh.products.dto.ProductRecord;
import vn.tuananh.products.entity.Product;

public class ProductMapper {
    public static ProductRecord toProductRecord(Product product){
        return  new ProductRecord(product.getName(), product.getPrice(), product.getBrand(), product.getCount());
    }
}
