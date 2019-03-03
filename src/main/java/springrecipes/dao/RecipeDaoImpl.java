package springrecipes.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springrecipes.model.Recipe;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class RecipeDaoImpl implements RecipeDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Recipe> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipe> criteria = builder.createQuery(Recipe.class);
        criteria.from(Recipe.class);
        List<Recipe> recipes = session.createQuery(criteria).getResultList();
        session.close();
        return recipes;
    }

    @Override
    public Recipe findById(int id) {
        Session session = sessionFactory.openSession();
        Recipe recipe = session.get(Recipe.class, id);
        session.close();
        return recipe;
    }

    @Override
    public void save(Recipe recipe) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(recipe); // Difference between save() and saveOrUpdate()?
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Recipe recipe) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(recipe);
        session.getTransaction().commit();
        session.close();
    }
}
