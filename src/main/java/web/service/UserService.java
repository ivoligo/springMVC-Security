package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    List<User> getAllUsersWithRole();
    void create(User user);
    void update(User user);
    void delete(User user);

    User findUserByEmail(String email);
    User findUserById(Long id);

}
