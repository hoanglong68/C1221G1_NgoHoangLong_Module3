package service;

import model.Category;
import repository.CategoryRepositoryImpl;
import repository.ICategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService{
    ICategoryRepository categoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Category> displayCategoryList() {
        return categoryRepository.displayCategoryList();
    }
}
