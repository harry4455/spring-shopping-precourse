package shopping;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import shopping.Controller.TestRequest;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

// randomPort로 편하게 사용 가능
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductRestControllerTest {

    // local 환경에서 포트 번호 주입 가능
    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplateBuilder builder;
    private RestTemplate client;
    private RestClient restClient;
//    private WebTestClient webClient;

    @BeforeEach
    void setUp() {
        client = builder.build();
    }

    @Test
    void test1() {
        var url = "http://localhost:"+port+"/api/test";
        final String actual = client.getForObject(url, String.class);
        assertThat(actual).isEqualTo("Hello World");
    }

    @Test
    void test2() {
        var url = "http://localhost:"+port+"/api/test?name=Harry";
        final String actual = client.getForObject(url, String.class);
        assertThat(actual).isEqualTo("Hello Harry");
    }

    @Test
    void test3() {
        var url = "http://localhost:"+port+"/api/test";
//        var json = "{\"name\":\"Harry\"}";
        var request = new RequestEntity<>(
                new TestRequest("Harry"),
                HttpMethod.POST,
                URI.create(url)
        );
        var actual = client.exchange(request, String.class).getBody();
        assertThat(actual).isEqualTo("Hello Harry");
    }
}
