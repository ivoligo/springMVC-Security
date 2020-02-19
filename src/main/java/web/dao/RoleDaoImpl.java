package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository

public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> allRoles() {
        TypedQuery<Role> query= sessionFactory.getCurrentSession().createQuery("from Role");
        return query.getResultList();
    }

    @Override
    public void add(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

}
