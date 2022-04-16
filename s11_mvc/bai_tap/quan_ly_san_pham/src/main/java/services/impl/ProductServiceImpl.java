package services.impl;

import models.Product;
import repository.ICrudRepository;
import repository.impl.ProductRepositoryImpl;
import services.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    ICrudRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> getList() {
        return productRepository.getList();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }
}
