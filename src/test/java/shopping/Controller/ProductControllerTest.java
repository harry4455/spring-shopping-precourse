package shopping.Controller;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
