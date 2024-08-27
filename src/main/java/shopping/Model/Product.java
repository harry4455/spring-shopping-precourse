package shopping.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Product() {
    }

    private String name;
    private Integer price;
    private String imgUrl;

    public Product(String imgUrl, String name, Integer price) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                '}';
    }

}
