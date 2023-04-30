package sk.stuba.fei.uim.oop.assignment3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.model.Product;
import sk.stuba.fei.uim.oop.assignment3.repository.ProductRepository;
import sk.stuba.fei.uim.oop.assignment3.request.ProductAmountRequest;
import sk.stuba.fei.uim.oop.assignment3.request.ProductNameDescriptionRequest;
import sk.stuba.fei.uim.oop.assignment3.request.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.response.ProductAmountResponse;
import sk.stuba.fei.uim.oop.assignment3.response.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.service.CartService;
import sk.stuba.fei.uim.oop.assignment3.service.ProductService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ArrayList<Product> getAllProducts() {
        return productService.getProduct();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponse> getProductId(@PathVariable(name = "id") Long id) {
        Optional<Product> product = productService.getProduct(id);
        return product.map(value -> new ResponseEntity<>(new ProductResponse(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/product/{id}/amount")
    public ResponseEntity<ProductAmountResponse> getProductAmount(@PathVariable(name = "id") Long id) {
        Optional<Product> product = productService.getProduct(id);
        return product.map(value -> new ResponseEntity<>(new ProductAmountResponse(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/product")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        String productName = productRequest.getName();
        String productDescription = productRequest.getDescription();
        Long productAmount = productRequest.getAmount();
        String productUnit = productRequest.getUnit();
        Double productPrice = productRequest.getPrice();

        Product product = new Product(productName, productDescription, productAmount, productUnit, productPrice);
        productService.addProduct(product);
        return new ResponseEntity<>(new ProductResponse(product), HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable(name = "id") Long id, @RequestBody ProductRequest productRequest) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // TODO rework

        if (productRequest.getName() != null) {
            product.get().setName(productRequest.getName());
        }
        if (productRequest.getDescription() != null) {
            product.get().setDescription(productRequest.getDescription());
        }
        if (productRequest.getAmount() != null) {
            product.get().setAmount(productRequest.getAmount());
        }
        if (productRequest.getUnit() != null) {
            product.get().setUnit(productRequest.getUnit());
        }
        if (productRequest.getPrice() != null) {
            product.get().setPrice(productRequest.getPrice());
        }

        return new ResponseEntity<>(new ProductResponse(product.get()), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable(name = "id") Long id) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/product/{id}/amount")
    public ResponseEntity<ProductAmountResponse> incrementAmount(@PathVariable(name = "id") Long id, @RequestBody ProductAmountRequest productAmountRequest) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.get().incrementAmount(productAmountRequest.getAmount());
        return new ResponseEntity<>(new ProductAmountResponse(product.get()), HttpStatus.OK);}
}
