package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    List<User> getAllUsersWithRole();
    void create(User user);
    void update(User user);
    void delete(User user);

    User findUserByEmail(String email);
    User findUserById(Long id);

    List<User> findAllWithRole();


}
