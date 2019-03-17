package springrecipes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springrecipes.model.Category;
import springrecipes.service.CategoryService;
import springrecipes.service.RecipeService;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        modelMap.put("categories", categoryService.findAll());
        return "category/index";
    }

    @RequestMapping("/categories/{id}")
    public String categoryDetails(@PathVariable Category category, ModelMap modelMap) {
        //modelMap.put("category", categoryRepository.findById(id));
        //modelMap.put("recipes", recipeRepository.findByCategory(category));
        return "category/details";
    }
}
