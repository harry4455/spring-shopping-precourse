package shopping;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class ApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void test1() {
        System.out.println("test1 = " + context);
    }

    @Test
    void test2() {
        System.out.println("test2 = " + context);
    }

    @DirtiesContext
    @Test
    void test3() {
        System.out.println("test3 = " + context);
    }
}