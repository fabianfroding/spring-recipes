package springrecipes.data;

import org.springframework.stereotype.Component;
import springrecipes.model.Category;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category("Chicken", 1),
            new Category("Paleo", 2),
            new Category("Desserts", 3),
            new Category("Soups", 4),
            new Category("Red Meat/Pork", 5)
    );

    public List<Category> getAll() {
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
