package com.daos;

import com.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryDao {

    List<Category> getAllCategory();

    void addCategory(Category category);

    Category getCategoryById(int id);

    void updateCategory(Category category);

    void deleteCategory(int id);
}
