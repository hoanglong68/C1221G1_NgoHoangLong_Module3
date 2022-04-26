package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepositoryImpl;
import utils.Regex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {
    IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> displayProductList() {
        return productRepository.displayProductList();
    }

    @Override
    public Map<String, String> insertProduct(Product product) {
        Map<String, String> errorList = new HashMap<>();
        if ("".equals(product.getName())) {
            errorList.put("name", "name is not empty !");
        }
        if (product.getPrice() == null) {
            errorList.put("price", "price is not empty !");
        } else if (product.getPrice() < 10000000) {
            errorList.put("price", "price must be > 10m !");
        }
        if (product.getQuantity() == null) {
            errorList.put("quantity", "quantity is not empty !");
        } else if (!product.getQuantity().toString().matches(Regex.POSITIVE_NUMBER)) {
            errorList.put("quantity", "quantity must be positive number !");
        }
        if (errorList.isEmpty()) {
            productRepository.insertProduct(product);
        }
        return errorList;
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> findProduct(String name, String price) {
        return productRepository.findProduct(name, price);
    }
}
