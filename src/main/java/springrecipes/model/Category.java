package springrecipes.model;

import java.util.List;

public class Category {
    private String name;
    private List<Recipe> recipes;

    //===== Constructor(s) =====//
    public Category(String name) {
        this.name = name;
    }

    //===== Getters & Setters =====//
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

}
