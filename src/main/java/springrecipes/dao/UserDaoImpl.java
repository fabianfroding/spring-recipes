package springrecipes.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springrecipes.model.User;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaQuery<User> criteria = session.getCriteriaBuilder().createQuery(User.class);
        criteria.from(User.class);
        List<User> users = session.createQuery(criteria).getResultList();
        session.close();
        return users;
    }

    @Override
    public User findById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, username);
        session.close();
        return user;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
