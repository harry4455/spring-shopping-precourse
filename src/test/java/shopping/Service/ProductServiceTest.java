package shopping.Service;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shopping.Repository.ProductRepository;

import java.util.Optional;

import static org.awaitility.Awaitility.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@Transactional
@SpringBootTest
public class ProductServiceTest {
    private ProductService productService;
    private ProductRepository productRepository = mock(ProductRepository.class);

    @BeforeEach
    void setUp() throws Exception {
        productService = new ProductService(productRepository);
    }

    @Test
    void update() {
        /**
         * 환경 설정 없이도 단위테스트가 가능하다
         * Mockists 의 주장
         * 해당 테스트는 greyBox 테스트에 해당
         * repository 내에서 findById, save에 대한 부분을 인지하고 진행하였기 때문
         */

        //given
        var productId = 1L;
        var product = new Product();
//        when(productRepository.findById(any())).thenReturn(Optional.of(product));
        given(productRepository.findById(any())).willReturn(Optional.of(product));

        //when
        productService.update(productId, "cafeLatte");

        //then
//        verify(productRepository, times(1)).save(any());
        then(productRepository).should(times(1)).save(any());
    }

//    @Test
//    void update() {
//        var product = productRepository.save(new Product("Americano", "10000","url"));
//        var productId = product.getId();
//        productService.update(productId, "cafeLatte");
//        var actual = productRepository.findById(productId);
//        Assertions.assertThat(actual.getName()).isEqualTo("cafeLatte");
//    }
}
