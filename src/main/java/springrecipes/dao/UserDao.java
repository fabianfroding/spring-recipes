package springrecipes.dao;

import springrecipes.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(int id);
    User findByUsername(String username);
    void save(User user);
    void delete(User user);
}
