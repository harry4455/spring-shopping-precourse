package shopping.Controller;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shopping.Model.Product;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Test
    void 상품명으로_조회한다() {
        var actual = productController.getProducts("apple");
        var json = "{name='apple', imgUrl='url', price=100.0}";
//        assertThat(actual).isNotNull();
        assertThat(actual.toString()).isEqualTo(json);
    }

    @Test
    void 상품을_등록한다() {
        Product product = new Product("url2", "grape", 1000.0);
        Boolean b = productController.addProduct(product);
        assertThat(b).isTrue();
    }
}
