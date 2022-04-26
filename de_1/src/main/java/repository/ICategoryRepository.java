package repository;

import model.Category;

import java.util.List;

public interface ICategoryRepository extends ICrudRepository{
    List<Category> displayCategoryList();
}
