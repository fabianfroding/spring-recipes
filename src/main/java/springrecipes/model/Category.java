package springrecipes.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Recipe> recipes = new ArrayList<>();

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
