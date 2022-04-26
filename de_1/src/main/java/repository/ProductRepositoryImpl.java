package repository;

import model.Product;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Product> displayProductList() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from products");
            Product product;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("id_product"));
                product.setName(resultSet.getString("name_product"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setIdColor(resultSet.getInt("id_color"));
                product.setIdCategory(resultSet.getInt("id_category"));
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public void insertProduct(Product product) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall
                    ("{call sp_create_product(?,?,?,?,?)}");
            callableStatement.setString(1, product.getName());
            callableStatement.setDouble(2, product.getPrice());
            callableStatement.setInt(3, product.getQuantity());
            callableStatement.setInt(4, product.getIdColor());
            callableStatement.setInt(5, product.getIdCategory());
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall
                    ("{call sp_delete_product(?)}");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> findProduct(String name, String price) {
        List<Product> productFindList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from products where name_product like ? and price like ?");
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + price + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("id_product"));
                product.setName(resultSet.getString("name_product"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setIdColor(resultSet.getInt("id_color"));
                product.setIdCategory(resultSet.getInt("id_category"));
                productFindList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return productFindList;
    }
}
