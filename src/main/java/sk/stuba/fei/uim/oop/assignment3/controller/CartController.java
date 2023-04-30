package sk.stuba.fei.uim.oop.assignment3.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.model.*;
import sk.stuba.fei.uim.oop.assignment3.response.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.service.CartService;
import sk.stuba.fei.uim.oop.assignment3.service.ProductService;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@RestController
public class CartController {
    private final CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @Autowired
    private ProductService productService;
    @PostMapping("/cart")
    public ResponseEntity<CartResponse> createCart() {
        Long cartId = cartService.getId();
        Cart cart = new Cart(cartId, new ArrayList<ShoppingItem>(), false);
        cartService.addCart(cart);
        return new ResponseEntity<>(new CartResponse(cart), HttpStatus.CREATED);
    }

    @GetMapping("/cart")
    public ArrayList<Cart> getAllCarts() {
        return cartService.getCarts();
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable(name = "id") Long id) {
        Optional<Cart> optional = cartService.getCart(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CartResponse(optional.get()), HttpStatus.OK);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<HttpStatus> removeCartById(@PathVariable(name = "id") Long id) {
        Optional<Cart> optional = cartService.getCart(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cartService.removeCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/cart/{id}/pay")
    public ResponseEntity<String> payCart(@PathVariable(name = "id") Long id) {
        Optional<Cart> optional = cartService.getCart(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (optional.get().isPayed()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        optional.get().setPayed(true);
        double price = 0.0;
        for (ShoppingItem shoppingItem : optional.get().getShoppingList()) {
            Optional<Product> optionalProduct = productService.getProduct(shoppingItem.getProductId());
            if (optionalProduct.isPresent()) {
                price += optionalProduct.get().getPrice() * shoppingItem.getAmount();
            }
        }
        return new ResponseEntity<>(Double.toString(price), HttpStatus.OK);
    }

    @PostMapping("/cart/{id}/add")
    public ResponseEntity<CartResponse> addToShoppingCart(@PathVariable(name = "id") Long id, @RequestBody ShoppingItem shoppingItem) {
        Optional<Cart> optionalCart = cartService.getCart(id);
        Optional<Product> optionalProduct = productService.getProduct(shoppingItem.getProductId());
        if (optionalCart.isEmpty() || optionalProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (optionalCart.get().isPayed() || (shoppingItem.getAmount() > optionalProduct.get().getAmount())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        for (ShoppingItem shoppingItem1 : optionalCart.get().getShoppingList()) {
            if (Objects.equals(shoppingItem1.getProductId(), shoppingItem.getProductId())) {
                shoppingItem1.setAmount(shoppingItem1.getAmount() + shoppingItem.getAmount());
                optionalProduct.get().setAmount(optionalProduct.get().getAmount() - shoppingItem.getAmount());
                return new ResponseEntity<>(new CartResponse(optionalCart.get()), HttpStatus.OK);
            }
        }

        optionalCart.get().getShoppingList().add(shoppingItem);
        optionalProduct.get().setAmount(optionalProduct.get().getAmount() - shoppingItem.getAmount());
        return new ResponseEntity<>(new CartResponse(optionalCart.get()), HttpStatus.OK);
    }
}
