package ru.gb.dao.product;

import ru.gb.entity.Product;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);
    List<Product> findAll();

}
