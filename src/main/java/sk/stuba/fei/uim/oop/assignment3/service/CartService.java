package sk.stuba.fei.uim.oop.assignment3.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.model.Cart;
import sk.stuba.fei.uim.oop.assignment3.repository.CartRepository;

import java.util.Optional;

@Service
public class CartService {
    private final CartRepository repository;
    public CartService(CartRepository repository) {
        this.repository = repository;
    }
    public void addCart(Cart cart) {
        repository.save(cart);
    }
    public void removeCart(Long id) {
        Optional<Cart> optional = repository.findById(id);
        optional.ifPresent(repository::delete);
    }
    public Optional<Cart> getCart(Long id) {
        return repository.findById(id);
    }
}
