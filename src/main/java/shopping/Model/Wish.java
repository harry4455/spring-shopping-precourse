package shopping.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Wish {

    @Id
    private Long wishId;
    private Long memberId;
    private Long productId;

    public Wish(Long wishId, Long memberId) {
        this.wishId = wishId;
        this.memberId = memberId;
    }
}
