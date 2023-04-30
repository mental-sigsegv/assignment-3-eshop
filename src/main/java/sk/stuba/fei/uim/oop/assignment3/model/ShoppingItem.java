package sk.stuba.fei.uim.oop.assignment3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter @Entity @JsonIgnoreProperties(value = { "id" })
public class ShoppingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long productId;
    private Long amount;
    public ShoppingItem(Long productId, Long amount) {
        this.productId = productId;
        this.amount = amount;
    }
}
