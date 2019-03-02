package springrecipes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springrecipes.model.Recipe;

import java.time.LocalDate;

// @RequestMapping: Maps a certain URI request to a Java method.
// @ResponseBody: Use returned value as plain text instead of a html template.

@Controller
public class RecipeController {
    @RequestMapping("/") // URI pattern mapped to this method.
    public String listRecipes() {
        return "recipe/index";
    }

    @RequestMapping("/recipe")
    public String recipeDetails(ModelMap modelMap) {
        Recipe recipe = new Recipe("Hawaiian-Style Chicken Thighs");
        recipe.setId(1);
        recipe.setDateAdded(LocalDate.of(2019, 03, 02));
        recipe.setUsername("Fabian");
        modelMap.put("recipe", recipe);
        return "recipe/details";
    }
}
