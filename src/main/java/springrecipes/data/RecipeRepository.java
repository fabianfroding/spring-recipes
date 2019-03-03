package springrecipes.data;

import org.springframework.stereotype.Component;
import springrecipes.model.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RecipeRepository {
    private static final List<Recipe> ALL_RECIPES = Arrays.asList(
            new Recipe("Recipe 1"),
            new Recipe("Recipe 2"),
            new Recipe("Recipe 3"),
            new Recipe("Recipe 4"),
            new Recipe("Recipe 5"),
            new Recipe("Recipe 6")
    );

    public List<Recipe> getAll() {
        return ALL_RECIPES;
    }

    public Recipe findByName(String name) {
        for (Recipe recipe : ALL_RECIPES) {
            if (recipe.getName().equalsIgnoreCase(name)) {
                return recipe;
            }
        }
        return null;
    }

    public List<Recipe> findByCategoryId(int id) {
        List<Recipe> recipes = new ArrayList<>();
        for (Recipe recipe : ALL_RECIPES) {
            if (recipe.getCategoryId() == id) {
                recipes.add(recipe);
            }
        }
        return recipes;
    }
}
