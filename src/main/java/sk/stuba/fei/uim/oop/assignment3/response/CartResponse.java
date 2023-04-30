package sk.stuba.fei.uim.oop.assignment3.response;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.Cart;
import sk.stuba.fei.uim.oop.assignment3.model.ShoppingItem;

import java.util.ArrayList;

@Getter
public class CartResponse {
    private Long id;
    private ArrayList<ShoppingItem> shoppingList;
    private boolean payed;
    public CartResponse(Cart c) {
        this.id = c.getId();
        this.shoppingList = c.getShoppingList();
        this.payed = c.isPayed();
    }
}
