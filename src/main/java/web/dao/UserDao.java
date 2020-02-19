package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    List<User> getAllUsersWithRole();
    User create(User user);
    User update(User user);
    void delete(User user);

    User findUserByEmail(String email);
    User findUserById(Long id);

    List<User> findAllWithRole();


}
