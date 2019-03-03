package springrecipes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springrecipes.data.RecipeRepository;
import springrecipes.model.Recipe;

import java.time.LocalDate;

@Controller
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping(value = {"/", "/recipes"})
    public String listRecipes(ModelMap modelMap) {
        modelMap.put("recipes", recipeRepository.getAll());
        return "recipe/index";
    }

    @RequestMapping("/recipes/{name}")
    public String recipeDetails(@PathVariable String name, ModelMap modelMap) {
        Recipe recipe = recipeRepository.findByName(name);
        recipe.setDateAdded(LocalDate.of(2019, 03, 02));
        recipe.setUsername("Fabian");
        modelMap.put("recipe", recipe);
        return "recipe/details";
    }
}
