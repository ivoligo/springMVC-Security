package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query= sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();

    }

    @Override
//    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> getAllUsersWithRole() {
        TypedQuery<User> query= sessionFactory.getCurrentSession().createQuery("select user from User user" + " join fetch user.roleSet ");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void create(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
//            sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().remove(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where email = '" + email + "' ").uniqueResult();
    }

    @Override
    public User findUserById(Long id) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where id = '" + id + "' ").uniqueResult();
//    User user = (User) sessionFactory.getCurrentSession().createQuery(
//            "select user from User user "
//            + "join fetch user.roleSet"
//            + " where user.id = :id").setParameter("id", id);
//    return user;
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where email = '" + username + "' ").uniqueResult();
//        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
        public List<User> findAllWithRole() {
        return null;
    }

}
