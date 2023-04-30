package sk.stuba.fei.uim.oop.assignment3.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.model.Cart;
import sk.stuba.fei.uim.oop.assignment3.response.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.service.CartService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class CartController {
    private final CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public ResponseEntity<CartResponse> createCart() {
        Long cartId = cartService.getId();
        Cart cart = new Cart(cartId, null, true);
        cartService.addCart(cart);
        return new ResponseEntity<>(new CartResponse(cart), HttpStatus.CREATED);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<CartResponse> getCardById(@PathVariable(name = "id") Long id) {
        Optional<Cart> optional = cartService.getCart(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CartResponse(optional.get()), HttpStatus.OK);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<HttpStatus> removeCardById(@PathVariable(name = "id") Long id) {
        Optional<Cart> optional = cartService.getCart(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cartService.removeCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
