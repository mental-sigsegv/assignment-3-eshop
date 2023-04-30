package sk.stuba.fei.uim.oop.assignment3.response;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.Product;

@Getter
public class ProductResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final Long amount;
    private final String unit;
    private final Double price;

    public ProductResponse(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        amount = product.getAmount();
        unit = product.getUnit();
        price = product.getPrice();
    }
}