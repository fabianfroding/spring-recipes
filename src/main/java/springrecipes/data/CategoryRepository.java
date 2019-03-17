package springrecipes.data;

import org.springframework.stereotype.Component;
import springrecipes.model.Category;

import java.util.Arrays;
import java.util.List;

/*
@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category("Chicken", 0),
            new Category("Desserts", 1),
            new Category("Paleo", 2),
            new Category("Red Meat/Pork", 3),
            new Category("Soups", 4)
    );

    public List<Category> findAll() {
        return ALL_CATEGORIES;
    }

    public Category findById(int id) {
        for (Category category : ALL_CATEGORIES) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
*/
