package sk.stuba.fei.uim.oop.assignment3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.model.ShoppingItem;

import java.util.ArrayList;

@Repository
public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Long> {
    ArrayList<ShoppingItem> findAll();
}
