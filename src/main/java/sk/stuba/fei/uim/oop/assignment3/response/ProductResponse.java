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

    public ProductResponse(Product p) {
        id = p.getId();
        name = p.getName();
        description = p.getDescription();
        amount = p.getAmount();
        unit = p.getUnit();
        price = p.getPrice();
    }
}