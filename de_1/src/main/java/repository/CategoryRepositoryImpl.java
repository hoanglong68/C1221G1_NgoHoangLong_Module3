package repository;

import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Category> displayCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from category");
            Category category;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category = new Category();
                category.setIdCategory(resultSet.getInt("id_category"));
                category.setNameCategory(resultSet.getString("name_category"));
                categoryList.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return categoryList;
    }
}
