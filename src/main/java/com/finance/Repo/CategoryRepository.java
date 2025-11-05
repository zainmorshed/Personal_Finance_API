package com.finance.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.finance.entity.Category;
import com.finance.entity.expenseType;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByType(expenseType type);
    List<Category> findByName(String name);
}
