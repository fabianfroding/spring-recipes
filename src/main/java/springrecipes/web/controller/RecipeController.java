package springrecipes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springrecipes.model.Recipe;
import springrecipes.service.RecipeService;

@Controller
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = {"/", "/recipes"})
    public String listRecipes(ModelMap modelMap) {
        modelMap.put("recipes", recipeService.findAll());
        return "recipe/index";
    }

    @RequestMapping("/recipes/{id}")
    public String recipeDetails(@PathVariable int id, ModelMap modelMap) {
        modelMap.put("recipe", recipeService.findById(id));
        modelMap.addAttribute("action", "/recipes/delete");
        modelMap.addAttribute("submit", "Delete");
        return "recipe/details";
    }

    @RequestMapping(value = "/recipes/save", method = RequestMethod.POST)
    public String saveRecipe(Recipe recipe) {
        recipeService.save(recipe);
        return "redirect:/recipes/" + recipe.getId();
    }

    @RequestMapping("/recipes/add")
    public String formNewRecipe(ModelMap modelMap) {
        if(!modelMap.containsAttribute("recipe")) {
            modelMap.addAttribute("recipe",new Recipe());
        }
        modelMap.addAttribute("action", "/recipes/save");
        modelMap.addAttribute("submit", "Add");
        return "recipe/form";
    }

    @RequestMapping(value = "/recipes/{id}/delete", method = RequestMethod.POST)
    public String deleteRecipe(@PathVariable int id) {
        recipeService.delete(recipeService.findById(id));
        return "redirect:/recipes";
    }

}
