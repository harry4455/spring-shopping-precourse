package shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

}
