package sk.stuba.fei.uim.oop.assignment3.response;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.Product;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Double price;

    public ProductResponse(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        amount = product.getAmount();
        unit = product.getUnit();
        price = product.getPrice();
    }
}