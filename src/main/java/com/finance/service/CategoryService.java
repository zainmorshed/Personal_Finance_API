package com.finance.service;
import java.util.List;
import com.finance.entity.*;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getCategories();
    Category getCategoryById(Long id);
    void deleteCategory(Long id);
}
