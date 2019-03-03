package springrecipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springrecipes.dao.RecipeDao;
import springrecipes.model.Recipe;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeDao recipeDao;

    @Override
    public List<Recipe> findAll() {
        return recipeDao.findAll();
    }

    @Override
    public Recipe findById(int id) {
        return recipeDao.findById(id);
    }

    @Override
    public void save(Recipe recipe) {
        recipeDao.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        recipeDao.delete(recipe);
    }
}
