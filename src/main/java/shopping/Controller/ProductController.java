package shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopping.Model.Product;
import shopping.Service.ProductService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 상품 조회 (상품명 기준)
    @GetMapping
    public ResponseEntity<?> getProducts(@RequestParam(required = false) String name) {

        if (name != null) {
            var byName = productService.findByName(name);
            System.out.println("byName = " + byName);
            if(byName != null) {
                return ResponseEntity.ok(byName);
            }
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.notFound().build();
    }

    // 상품 추가
    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {

        var result = productService.addProduct(product);
        System.out.println("result = " + result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 상품 수정
//    @PutMapping("/api/products")
//    public Product updateProduct(@RequestParam(required = true) String name, @RequestBody Product product) {
//
//        products.get(name).setImgUrl(product.getImgUrl());
//        products.get(name).setPrice(product.getPrice());
//
//        return products.get(name);
//    }

    // 상품 삭제
//    @DeleteMapping("/api/products")
//    public Product deleteProduct(@RequestParam(required = true) String name) {
//
//        return products.remove(name);
//    }
}
