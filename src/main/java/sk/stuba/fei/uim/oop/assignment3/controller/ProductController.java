package sk.stuba.fei.uim.oop.assignment3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.model.Product;
import sk.stuba.fei.uim.oop.assignment3.request.ProductAmountRequest;
import sk.stuba.fei.uim.oop.assignment3.request.ProductRequest;
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

    @PostMapping("/product")
    public ResponseEntity<ProductResponse> createProduct() {
        Long productId = productService.getId();
        Product product = new Product(productId, "none", "empty", 0L, "0", 0.0);
        productService.addProduct(product);
        return new ResponseEntity<>(new ProductResponse(product), HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable(name = "id") Long id, @RequestBody ProductRequest productRequest) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String newProductName = productRequest.getName();
        String newProductDescription = productRequest.getDescription();
        product.get().setName(newProductName);
        product.get().setDescription(newProductDescription);
        return new ResponseEntity<>(new ProductResponse(product.get()), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public HttpStatus deleteProduct(@PathVariable(name = "id") Long id) {
        Optional<Product> product = productService.getProduct(id);
        if (product.isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }
        productService.removeProduct(id);
        return HttpStatus.OK;
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
