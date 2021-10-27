package com.services;

import com.daos.CategoryDao;
import com.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    public Category getCategoryById(int id) {
        return categoryDao.getCategoryById(id);
    }

    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    public void deleteCategory(int id){
        categoryDao.deleteCategory(id);
    }

}
