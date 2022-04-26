package repository;

import model.Product;

import java.util.List;

public interface IProductRepository extends ICrudRepository{
    List<Product> displayProductList();

    void insertProduct(Product product);

    void deleteProduct(Integer id);

    List<Product> findProduct(String name, String price);
}
