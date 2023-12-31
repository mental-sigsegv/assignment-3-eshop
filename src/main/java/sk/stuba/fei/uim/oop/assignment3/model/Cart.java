package sk.stuba.fei.uim.oop.assignment3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
public class Cart {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter @Setter
    private ArrayList<ShoppingItem> shoppingList;
    @Getter @Setter
    private boolean payed;
    public Cart(ArrayList<ShoppingItem> shoppingList, boolean payed) {
        this.shoppingList = shoppingList;
        this.payed = payed;
    }
}
