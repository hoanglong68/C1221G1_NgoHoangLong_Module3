package service;

import model.Category;

import java.util.List;

public interface ICategoryService extends IService{
    List<Category> displayCategoryList();
}
