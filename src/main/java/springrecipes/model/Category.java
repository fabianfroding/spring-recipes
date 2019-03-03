package springrecipes.model;

public class Category {
    private int id;
    private String name;

    //===== Constructor(s) =====//
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

}
