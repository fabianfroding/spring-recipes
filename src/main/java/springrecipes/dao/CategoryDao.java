package springrecipes.dao;

import springrecipes.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
    Category findById(int id);
    void save(Category recipe);
    void delete(Category recipe);
}
