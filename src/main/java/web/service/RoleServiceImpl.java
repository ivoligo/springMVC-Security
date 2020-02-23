package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Role> allRoles() {
        return roleDao.allRoles();
    }

    @Override
    @Transactional
    public void add(Role role) {
        Role roleAdmin = new Role( "admin");
        Role roleUser = new Role("user");
        Role roleWebUser = new Role("webUser");
        Role roleOtherUser = new Role("otherUser");
        roleDao.add(roleAdmin);
        roleDao.add(roleUser);
        roleDao.add(roleWebUser);
        roleDao.add(roleOtherUser);
//        roleDao.add(role);
    }

    @Override
    @Transactional
    public Role findRoleByName(String name) {
        return roleDao.findRoleByName(name);
    }


}
