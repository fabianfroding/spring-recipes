package springrecipes.service;

import springrecipes.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> findAll();
    Recipe findById(int id);
    void save(Recipe recipe);
    void delete(Recipe recipe);
}
