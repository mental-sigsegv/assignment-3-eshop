package sk.stuba.fei.uim.oop.assignment3.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.model.Cart;
import sk.stuba.fei.uim.oop.assignment3.model.Product;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartService {
    @Getter
    @Setter
    private ArrayList<Cart> carts;
    @Getter @Setter
    private Long id;
    public CartService() {
        carts = new ArrayList<>();
        id = 1L;
    }

    public void addCart(Cart cart) {
        carts.add(cart);
        id++;
    }

    public void removeCart(Long id) {
        for (Cart cart : carts) {
            if (Objects.equals(cart.getId(), id)) {
                carts.remove(cart);
                return;
            }
        }
    }

    public Optional<Cart> getCart(Long id) {
        Optional<Cart> optional = Optional.empty();
        for (Cart cart : carts) {
            if (Objects.equals(cart.getId(), id)) {
                optional = Optional.of(cart);
                return optional;
            }
        }
        return optional;
    }
}
