package repository.impl;

import models.Product;
import repository.IProductRepository;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository {
    private static Map<Integer, Product> productList;
    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Chuối", (float) 20000, "Chín","VN"));
        productList.put(2, new Product(2,  "Táo", (float) 15000, "Xanh","USA"));
        productList.put(3, new Product(3,  "Nho", (float) 30000, "Chín","TQ"));
        productList.put(4, new Product(4,  "Súng", (float) 900000, "Hư","VN"));
        productList.put(5, new Product(5,  "Phóng Lợn", (float) 100000, "Mới","VN"));
        productList.put(6, new Product(6,  "Máy", (float) 40000, "Hư","TQ"));
    }

    public Map<Integer, Product> getProductsList() {
        return productList;
    }
}
