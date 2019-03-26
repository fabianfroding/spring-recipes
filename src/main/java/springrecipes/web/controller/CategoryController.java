package springrecipes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springrecipes.model.Category;
import springrecipes.model.Recipe;
import springrecipes.service.CategoryService;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        modelMap.put("categories", categoryService.findAll());
        return "category/index";
    }

    @RequestMapping("/categories/{id}")
    public String categoryDetails(@PathVariable int id, ModelMap modelMap) {
        modelMap.put("category", categoryService.findById(id));
        modelMap.addAttribute("action", "/categories/delete");
        modelMap.addAttribute("submit", "Delete");
        return "category/details";
    }

    @RequestMapping("/categories/add")
    public String formNewCategory(ModelMap modelMap) {
        if(!modelMap.containsAttribute("category")) {
            modelMap.addAttribute("category", new Category());
        }
        modelMap.addAttribute("action", "/categories/save");
        modelMap.addAttribute("submit", "Add");
        return "category/form";
    }

    @RequestMapping(value = "/categories/save", method = RequestMethod.POST)
    public String saveCategory(Category category) {
        categoryService.save(category);
        return "redirect:/categories/" + category.getId();
    }

    @RequestMapping(value = "/categories/{id}/delete", method = RequestMethod.POST)
    public String deleteCategory(@PathVariable int id) {
        categoryService.delete(categoryService.findById(id));
        return "redirect:/categories";
    }

    @RequestMapping(value ="categories/{id}/edit")
    public String formEditCategory(@PathVariable int id, ModelMap modelMap) {
        if (!modelMap.containsAttribute("category")) {
            modelMap.addAttribute("category", categoryService.findById(id));
        }
        modelMap.addAttribute("action","/categories/" + id);
        modelMap.addAttribute("submit", "Update");
        return "category/form";
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.POST)
    public String updateCategory(Category category) {
        categoryService.save(category);
        return "redirect:/categories/" + category.getId();
    }

}
