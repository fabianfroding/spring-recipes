package springrecipes.model;

import java.time.LocalDate;

public class Recipe {
    private int id;
    private int categoryId;
    private String name;
    private LocalDate dateAdded;
    private String username;

    //===== Constructor(s) =====//
    public Recipe(String name) {
        this.name = name;
    }

    //===== Getters & Setters =====//
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateAdded() {
        return dateAdded;
    }
    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
