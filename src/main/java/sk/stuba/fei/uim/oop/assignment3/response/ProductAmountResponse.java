package sk.stuba.fei.uim.oop.assignment3.response;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.Product;

@Getter
public class ProductAmountResponse {
    private final Long amount;
    public ProductAmountResponse(Product p) {
        this.amount = p.getAmount();
    }
}