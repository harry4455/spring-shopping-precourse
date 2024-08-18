package shopping.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private Long productId;

    private String productName;
    private Integer price;
    private String imgUrl;

    public Product(String productName, Integer price, String imgUrl) {
        this.productName = productName;
        this.price = price;
        this.imgUrl = imgUrl;
    }

}
