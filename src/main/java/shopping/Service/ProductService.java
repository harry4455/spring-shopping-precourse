package shopping.Service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import shopping.Repository.ProductRepository;

@Transactional
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void update(Long productId, String name ) {

    }
}
