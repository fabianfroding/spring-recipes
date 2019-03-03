package springrecipes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springrecipes.data.RecipeRepository;

@Controller
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping(value = {"/", "/recipes"})
    public String listRecipes(ModelMap modelMap) {
        modelMap.put("recipes", recipeRepository.findAll());
        return "recipe/index";
    }

    @RequestMapping("/recipes/{name}")
    public String recipeDetails(@PathVariable String name, ModelMap modelMap) {
        modelMap.put("recipe", recipeRepository.findByName(name));
        return "recipe/details";
    }
}
