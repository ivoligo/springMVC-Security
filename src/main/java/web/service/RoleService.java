package web.service;

import web.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> allRoles();
    void add(Role role);
    Role findRoleByName(String name);
    List<Role> findRoleListByName(List<String> name);
}
