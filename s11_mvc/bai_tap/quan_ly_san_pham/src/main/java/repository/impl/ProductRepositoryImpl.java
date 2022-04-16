package repository.impl;

import models.Product;
import repository.ICrudRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ICrudRepository {
    private static Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Chuối", (float) 20000, "Chín", "VN"));
        productList.put(2, new Product(2, "Táo", (float) 15000, "Xanh", "USA"));
        productList.put(3, new Product(3, "Nho", (float) 30000, "Chín", "TQ"));
        productList.put(4, new Product(4, "Súng", (float) 900000, "Hư", "VN"));
        productList.put(5, new Product(5, "Phóng Lợn", (float) 100000, "Mới", "VN"));
        productList.put(6, new Product(6, "Máy", (float) 40000, "Hư", "TQ"));
    }

    @Override
    public List<Product> getList() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return getList().get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> producFindtList = new ArrayList<>();
        for (Product product : getList()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                producFindtList.add(product);
            }
        }
        return producFindtList;
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }
}
