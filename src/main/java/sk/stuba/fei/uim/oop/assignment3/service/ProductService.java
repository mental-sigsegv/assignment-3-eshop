package sk.stuba.fei.uim.oop.assignment3.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.model.Product;

import java.util.*;

@Service
public class ProductService {
    
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();

        Product product1 = new Product(1L, "Vodka", "Alcoholic drink", 1L, "1", 12L);
        Product product2 = new Product(2L, "Jager", "Alcoholic drink", 2L, "5", 13L);

        products.addAll(Arrays.asList(product1, product2));
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
