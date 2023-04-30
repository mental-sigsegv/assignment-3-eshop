package sk.stuba.fei.uim.oop.assignment3.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.model.Product;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class ProductService {
    
    private ArrayList<Product> products;
    @Getter
    private Long id;

    public ProductService() {
        products = new ArrayList<>();
        id = 1L;
    }
    public void addProduct(Product product) {
        products.add(product);
        id++;
    }

    public void removeProduct(Long id) {
        for (Product product : products) {
            if (Objects.equals(product.getId(), id)) {
                products.remove(product);
                return;
            }
        }
    }

    public ArrayList<Product> getProduct() {
        return products;
    }

    public Optional<Product> getProduct(Long id) {
        Optional<Product> optional = Optional.empty();
        for (Product product : products) {
            if (Objects.equals(product.getId(), id)) {
                optional = Optional.of(product);
                return optional;
            }
        }
        return optional;
    }
}
