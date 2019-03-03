package springrecipes.model;

import java.util.List;

public class Category {
    private int id;
    private String name;
    private List<Recipe> recipes;

    //===== Constructor(s) =====//
    public Category(String name) {
        this.name = name;
    }
    public Category(String name, int id) {
        this.name = name;
        this.id = id;
    }

    //===== Getters & Setters =====//
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
