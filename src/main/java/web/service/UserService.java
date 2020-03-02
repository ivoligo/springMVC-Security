package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUser();
    List<User> getAllUsersWithRole();
    void create(User user);
    void update(User user);
    void delete(User user);

    User findUserByEmail(String email);
    User findUserById(Long id);
    User findByUsername(String username);

}
