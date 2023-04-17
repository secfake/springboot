package vn.tuananh.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tuananh.products.dto.ProductRecord;
import vn.tuananh.products.request.AddProduct;
import vn.tuananh.products.service.ProductService;
import vn.tuananh.products.service.ProductServiceImp;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    private ProductServiceImp proService;

    //    Trả về danh sách tất cả sản phẩm
    @GetMapping
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(proService.getProducts());
    }

    //    Tính tổng tiền tất cả sản phẩm trong giỏ hàng (Tổng tiền mỗi sản phẩm = price * count)
    @GetMapping("/total")
    public ResponseEntity<?> getTotal() {
        return ResponseEntity.ok(proService.getTotal());
    }

    //    Tìm các sản phẩm của thuơng hiệu “Apple”
    @GetMapping("/3")
    public ResponseEntity<?> searchBrand(@RequestParam(required = false) String brand) {
        return ResponseEntity.ok(proService.searchBrand(brand));
    }

    //    Tìm các sản phẩm có giá > 20000000
    @GetMapping("/4")
    public ResponseEntity<?> searchBrand(@RequestParam(required = false) int price) {
        return ResponseEntity.ok(proService.searchPrice(price));
    }

    //    Tìm các sản phẩm có chữ “pro” trong tên (Không phân biệt hoa thường)
    @GetMapping("/5")
    public ResponseEntity<?> searchName(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(proService.searchName(name));
    }

    //    Thêm 1 sản phẩm bất kỳ vào trong mảng product
    @PostMapping("/6")
    public ResponseEntity<?> addProduct(@RequestBody AddProduct pro) {
        return ResponseEntity.ok(proService.addProduct(pro));
    }

    //    Xóa tất cả sản phẩm của thương hiệu “Samsung” trong giỏ hàng
    @DeleteMapping("/7")
    public ResponseEntity<?> deletProduct(@RequestParam int id) {
        proService.deleteProduct(id);
        return ResponseEntity.ok("Delete success");
    }

    //    Sắp xếp giỏ hàng theo price tăng dần
    @GetMapping("/8")
    public ResponseEntity<?> sortPrice() {
        proService.sortPrice();
        return ResponseEntity.ok("sort price success");
    }

    //    Sắp xếp giỏ hàng theo count giảm dần
    @GetMapping("/9")
    public ResponseEntity<?> sortCount() {
        proService.sortCount();
        return ResponseEntity.ok("sort count success");
    }

    //    Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
    @GetMapping("/10")
    public ResponseEntity<?> selectProduct() {

        return ResponseEntity.ok(proService.selectProduct());
    }
}
