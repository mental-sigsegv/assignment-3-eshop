package sk.stuba.fei.uim.oop.assignment3.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProductAmountRequest {
    private final Long amount;
    public ProductAmountRequest(@JsonProperty("amount") Long amount) {
        this.amount = amount;
    }
}
