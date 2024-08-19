package shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopping.Model.Product;
import shopping.Service.ProductService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {
    private final Map<String, Product> products = new HashMap<>();

    @Autowired
    private ProductService productService;

    public ProductController() {
        products.put("apple", new Product("url", "apple", 100.0));
        products.put("grape", new Product("url2", "grape", 200.0));
    }

    // 상품 조회 (상품명 기준)
    @GetMapping("/api/products")
    public Product getProducts(@RequestParam(required = false) String name) {
        if (name != null) {
            return products.get(name);
        }
        return null;
    }

    // 상품 추가
    @PostMapping("/api/products")
    public Boolean addProduct(@RequestBody Product product) {
        Product newProduct = new Product(product.getImgUrl(), product.getName(), product.getPrice());
        products.put(product.getName(), newProduct);
        return products.containsValue(product);
    }

    // 상품 수정
    @PutMapping("/api/products")
    public Product updateProduct(@RequestParam(required = true) String name, @RequestBody Product product) {

        products.get(name).setImgUrl(product.getImgUrl());
        products.get(name).setPrice(product.getPrice());

        return products.get(name);
    }
}
