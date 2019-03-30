package springrecipes.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import springrecipes.model.User;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
