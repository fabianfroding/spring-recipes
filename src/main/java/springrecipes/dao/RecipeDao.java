package springrecipes.dao;

import springrecipes.model.Recipe;

import java.util.List;

public interface RecipeDao {
    List<Recipe> findAll();
    Recipe findById(int id);
    void save(Recipe recipe);
    void delete(Recipe recipe);
}
