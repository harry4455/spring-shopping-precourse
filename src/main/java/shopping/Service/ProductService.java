package shopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.Model.Product;
import shopping.Repository.ProductRepository;

import java.math.BigDecimal;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findByName(String name) {

        Product product = new Product();

        product.setName("apple");
        product.setImgUrl("url");
        product.setPrice(100.0);

        return product;
    }

    public int addProduct(Product product) {

        return 0;
    }
}
