package shopping.Service;

import jakarta.transaction.Transactional;
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
        return productRepository.findByName(name);
    }

    @Transactional
    public Product addProduct(Product product) {
        Product save = productRepository.save(product);
        System.out.println("save = " + save);
        return save;
    }
}
