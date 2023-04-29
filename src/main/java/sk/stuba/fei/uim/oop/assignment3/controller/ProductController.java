package sk.stuba.fei.uim.oop.assignment3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.model.Product;
import sk.stuba.fei.uim.oop.assignment3.response.ProductAmountResponse;
import sk.stuba.fei.uim.oop.assignment3.response.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.service.ProductService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ArrayList<Product> getAllProducts() {
        return productService.getProduct();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponse> getProductId(@PathVariable(name = "id") Long id) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProductResponse(product.get()), HttpStatus.OK);
    }

    @GetMapping("/product/{id}/amount")
    public ResponseEntity<ProductAmountResponse> getProductAmount(@PathVariable(name = "id") Long id) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ProductAmountResponse(product.get()), HttpStatus.OK);
    }
}