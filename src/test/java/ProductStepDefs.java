import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class ProductStepDefs extends SpringIntegrationTest{

    @Given("상품 이름이 {string}일 때")
    public void test1(String name) {
        System.out.println("name = " + name);
    }

    @When("상품을 생성하면")
    public void test2() {
        System.out.println("ProductStepDefs.test2");
    }

    @Then("{int}을 응답한다")
    public void test3(int status) {
        System.out.println("status = " + status);
        Assertions.assertThat(200).isEqualTo(status);
    }

    @And("{string}라고 응답한다")
    public void test4(String string) {
        System.out.println("string = " + string);
    }
}
