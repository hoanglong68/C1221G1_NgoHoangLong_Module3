package services.impl;

import models.Product;
import repository.impl.ProductRepositoryImpl;
import services.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {
    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productRepository.getProductsList().values());
    }

    @Override
    public void save(Product product) {
        productRepository.getProductsList().put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.getProductsList().get(id);
    }

    @Override
    public Product findByName(String name) {
        Product product = null;
        for (Map.Entry<Integer, Product> entry : productRepository.getProductsList().entrySet()) {
            if (entry.getValue().getName().contains(name)) {
                product = entry.getValue();
                break;
            }
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {
        productRepository.getProductsList().put(id, product);
    }

    @Override
    public void remove(int id) {
        productRepository.getProductsList().remove(id);
    }
}
