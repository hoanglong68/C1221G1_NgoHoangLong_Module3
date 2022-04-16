package services;

import models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();

    void save(Product product);

    Product findById(int id);

    List<Product> findByName(String name);

    void update(int id, Product product);

    void remove(int id);
}
