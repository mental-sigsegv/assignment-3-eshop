package sk.stuba.fei.uim.oop.assignment3.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.model.Cart;

import java.util.ArrayList;

@Service
public class CartService {
    private ArrayList<Cart> carts;
    private Long id;
    public CartService() {
        carts = new ArrayList<>();
        id = 1L;
    }
}
