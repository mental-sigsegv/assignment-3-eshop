package sk.stuba.fei.uim.oop.assignment3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.model.Product;
import sk.stuba.fei.uim.oop.assignment3.repository.ProductRepository;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public void addProduct(Product product) {
        repository.save(product);
    }
    public void removeProduct(Long id) {
        Optional<Product> optional = repository.findById(id);
        optional.ifPresent(repository::delete);
    }
    public ArrayList<Product> getProduct() {
        return repository.findAll();
    }
    public Optional<Product> getProduct(Long id) {
        return repository.findById(id);
    }
}
