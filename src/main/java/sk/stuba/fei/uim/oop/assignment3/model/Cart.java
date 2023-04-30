package sk.stuba.fei.uim.oop.assignment3.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Cart {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private ArrayList<ShoppingItem> shoppingList;
    @Getter @Setter
    private boolean payed;
    public Cart(Long id, ArrayList shoppingList, boolean payed) {
        this.id = id;
        this.shoppingList = shoppingList;
        this.payed = payed;
    }
}
