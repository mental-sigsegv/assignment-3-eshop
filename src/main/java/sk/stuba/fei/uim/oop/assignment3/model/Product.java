package sk.stuba.fei.uim.oop.assignment3.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestAttribute;

public class Product {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Long amount;
    @Getter @Setter
    private String unit;
    @Getter @Setter
    private Double price;

    public Product(Long id, String name, String description, Long amount, String unit, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.unit = unit;
        this.price = price;
    }

    public void incrementAmount(Long amount) {
        this.amount += amount;
    }
}
