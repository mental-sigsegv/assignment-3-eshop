package sk.stuba.fei.uim.oop.assignment3.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ShoppingItem {
    private Long productId;
    private Long amount;
    public ShoppingItem(Long productId, Long amount) {
        this.productId = productId;
        this.amount = amount;
    }
}
