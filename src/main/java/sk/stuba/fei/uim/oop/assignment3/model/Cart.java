package sk.stuba.fei.uim.oop.assignment3.model;

import java.util.ArrayList;

public class Cart {
    private Long id;
    private ArrayList<ShoppingItem> shoppingList;
    private boolean payed;
    public Cart(Long id, ArrayList shoppingList, boolean payed) {
        this.id = id;
        this.shoppingList = shoppingList;
        this.payed = payed;
    }
}
