package shopping.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRestController {

    // Intellij 내에서 자체적으로 local http 테스트 가능
    @GetMapping("/api/test")
    public String test(@RequestParam(required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @PostMapping("/api/test")
    public String test2(@RequestBody TestRequest request) {
        return "Hello " + request.name();
    }
}
