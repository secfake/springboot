package vn.tuananh.products.service;

import org.springframework.stereotype.Service;
import vn.tuananh.products.dto.ProductRecord;
import vn.tuananh.products.entity.Product;
import vn.tuananh.products.request.AddProduct;

import java.util.List;

@Service
public interface ProductService {
    public List<ProductRecord> getProducts();

    public int getTotal();

    public List<ProductRecord> searchBrand(String brand);

    public List<ProductRecord> searchPrice(int price);

    public List<ProductRecord> searchName(String name);

    public Product addProduct(AddProduct pro);

    public void deleteProduct(int id);

    public void sortPrice();

    public void sortCount();

    public List<ProductRecord> selectProduct();
}
