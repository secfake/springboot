package vn.tuananh.products.service;

import org.springframework.stereotype.Component;
import vn.tuananh.products.dto.ProductRecord;
import vn.tuananh.products.entity.Product;
import vn.tuananh.products.mapper.ProductMapper;
import vn.tuananh.products.request.AddProduct;

import java.util.*;

@Component
public class ProductServiceImp implements ProductService {
    private static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Iphone 14 Pro", 3000000, "Apple", 2));
        products.add(new Product(2, "Iphone 13", 2000000, "Apple", 3));
        products.add(new Product(3, "SamSung Utra 22", 3000000, "Sam Sung", 1));
    }

    @Override
    public List<ProductRecord> getProducts() {
        ArrayList<ProductRecord> productRecords = new ArrayList<>();
        for (Product pro : products) {
            productRecords.add(ProductMapper.toProductRecord(pro));
        }
        return productRecords;
    }

    @Override
    public int getTotal() {
        int total = 0;
        for (Product pro : products) {
            total += pro.getCount() * pro.getPrice();
        }
        return total;
    }

    @Override
    public List<ProductRecord> searchBrand(String brand) {
        ArrayList<ProductRecord> productRecords = new ArrayList<>();
        for (Product pro : products) {
            if (pro.getBrand().equals(brand))
                productRecords.add(ProductMapper.toProductRecord(pro));
        }
        return productRecords;
    }

    @Override
    public List<ProductRecord> searchPrice(int price) {
        ArrayList<ProductRecord> productRecords = new ArrayList<>();
        for (Product pro : products) {
            if (pro.getPrice() > price)
                productRecords.add(ProductMapper.toProductRecord(pro));
        }
        return productRecords;
    }

    @Override
    public List<ProductRecord> searchName(String name) {
        ArrayList<ProductRecord> productRecords = new ArrayList<>();
        for (Product pro : products) {
            if (pro.getName().toLowerCase().contains(name.toLowerCase()))
                productRecords.add(ProductMapper.toProductRecord(pro));
        }
        return productRecords;
    }

    @Override
    public Product addProduct(AddProduct pro) {
        Product p = new Product();
        p.setId(products.size() + 1);
        p.setName(pro.getName());
        p.setPrice(pro.getPrice());
        p.setBrand(pro.getBrand());
        p.setCount(pro.getCount());
        products.add(p);
        return p;
    }

    @Override
    public void deleteProduct(int id) {
        for (Product pro : products) {
            if (pro.getId() == id) {
                products.remove(pro);
            }

        }
    }

    @Override
    public void sortPrice() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }

    @Override
    public void sortCount() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getCount() - o1.getCount();
            }
        });
    }

    @Override
    public List<ProductRecord> selectProduct() {
        ArrayList<ProductRecord> productRecords = new ArrayList<>();
        ArrayList<Product> temp = new ArrayList<>(products);
        Collections.shuffle(temp);
        productRecords.add(ProductMapper.toProductRecord(temp.get(0)));
        productRecords.add(ProductMapper.toProductRecord(temp.get(1)));
        return productRecords;
    }
}
