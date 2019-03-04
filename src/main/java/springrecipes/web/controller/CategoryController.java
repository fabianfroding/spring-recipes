package springrecipes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springrecipes.data.CategoryRepository;
import springrecipes.data.RecipeRepository;
import springrecipes.model.Category;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        modelMap.put("categories", categoryRepository.findAll());
        return "category/index";
    }

    @RequestMapping("/categories/{id}")
    public String categoryDetails(@PathVariable Category category, ModelMap modelMap) {
        //modelMap.put("category", categoryRepository.findById(id));
        //modelMap.put("recipes", recipeRepository.findByCategory(category));
        return "category/details";
    }
}
