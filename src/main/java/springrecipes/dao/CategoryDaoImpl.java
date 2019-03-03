package springrecipes.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springrecipes.model.Category;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaQuery<Category> criteria = session.getCriteriaBuilder().createQuery(Category.class);
        criteria.from(Category.class);
        List<Category> categories = session.createQuery(criteria).getResultList();
        session.close();
        return categories;
    }

    @Override
    public Category findById(int id) {
        Session session = sessionFactory.openSession();
        Category category = session.get(Category.class, id);
        session.close();
        return category;
    }

    @Override
    public void save(Category category) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(category);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Category category) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(category);
        session.getTransaction().commit();
        session.close();
    }
}
