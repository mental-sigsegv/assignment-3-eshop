package sk.stuba.fei.uim.oop.assignment3.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.model.Product;
import sk.stuba.fei.uim.oop.assignment3.repository.ProductRepository;

import java.util.*;

@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public void addProduct(Product product) {
        repository.save(product);
    }
    public void removeProduct(Long id) {
        Optional<Product> optional = repository.findById(id);
        optional.ifPresent(repository::delete);
    }
    public ArrayList<Product> getProduct() {
        Iterable<Product> products = repository.findAll();
        ArrayList<Product> productArrayList = new ArrayList<>();
        products.forEach(productArrayList::add);
        return productArrayList;
    }
    public Optional<Product> getProduct(Long id) {
        return repository.findById(id);
    }
}
