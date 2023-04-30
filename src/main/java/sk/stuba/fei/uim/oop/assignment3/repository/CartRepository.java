package sk.stuba.fei.uim.oop.assignment3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.model.Cart;

import java.util.ArrayList;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    ArrayList<Cart> findAll();
}
