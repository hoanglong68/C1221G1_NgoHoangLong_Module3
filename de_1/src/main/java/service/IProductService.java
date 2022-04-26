package service;

import model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService extends IService{
    List<Product> displayProductList();

    Map<String, String> insertProduct(Product product);

    void deleteProduct(Integer id);

    List<Product> findProduct(String name, String price);
}
