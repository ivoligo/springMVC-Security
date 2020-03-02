package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Repository

public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> allRoles() {
        TypedQuery<Role> query= sessionFactory.getCurrentSession().createQuery("from Role");
//        Query query= sessionFactory.getCurrentSession().createQuery("from Role");
        return query.getResultList();
    }

    @Override
    public void add(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    @Transactional
    public Role findRoleByName(String name) {
        return (Role) sessionFactory.getCurrentSession().createQuery("from Role where rolesName = '" + name + "' ").uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> findRoleListByName(List<String> name) {
//        return (Role) sessionFactory.getCurrentSession().createQuery("from Role where rolesName = '" + name + "' ").uniqueResult();
//        return sessionFactory.getCurrentSession().createQuery("from Role where rolesName = '" + name + "' ").getResultList();
        TypedQuery<Role> query=sessionFactory.getCurrentSession().createQuery("from Role where rolesName = '" + name + "' ");
        return query.getResultList();
    }


}
