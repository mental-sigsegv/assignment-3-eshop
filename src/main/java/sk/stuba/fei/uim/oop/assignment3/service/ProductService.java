package sk.stuba.fei.uim.oop.assignment3.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.model.Product;

import java.util.*;

@Service
public class ProductService {
    
    private List<Product> products;
    @Getter
    private Long id;

    public ProductService() {
        products = new ArrayList<>();
        id = 1L;

        Product product1 = new Product(id, "Vodka", "Alcoholic drink", 1L, "1", 12.0);
        incId();
        Product product2 = new Product(id, "Jager", "Alcoholic drink", 2L, "5", 13.0);
        incId();

        products.addAll(Arrays.asList(product1, product2));
    }
    private void incId() {
        id++;
    }
    public void addProduct(Product product) {
        products.add(product);
        incId();
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
        return new ArrayList<>(this.products);
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
