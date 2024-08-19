package shopping.Controller;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import shopping.Model.Product;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ProductController productController;

    private RestClient restClient;

    @BeforeEach
    public void setUp() {
        restClient = RestClient.create();
    }

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

    @Test
    void 상품을_수정한다() {
        Product product = new Product("url33333", "grape", 100000.0);
//        Product updatedProduct = productController.updateProduct(product.getName(), product);
//        assertThat(updatedProduct).isEqualTo(productController.getProducts(product.getName()));

        var url = "http://localhost:"+port+"/api/products?name={name}";
        final Product actual = restClient.put()
                .uri(url, product.getName())
                .body(product)
//                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Product.class);

        assertThat(actual).isEqualTo(product);
        assertThat(actual.getPrice()).isEqualTo(100000.0);
    }

    @Test
    void 상품을_삭제한다() {
        Product grape = productController.getProducts("grape");
        var url = "http://localhost:"+port+"/api/products?name={name}";
        final Product actual = restClient.delete()
                .uri(url, grape.getName())
                .retrieve()
                .body(Product.class);

        assertThat(actual).isEqualTo(grape);
    }
}
