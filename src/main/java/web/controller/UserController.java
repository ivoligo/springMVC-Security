package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "admin/list", method = RequestMethod.GET)
    public String allUsers(Model model){
        List<User> listUsers = userService.getAllUser();
        model.addAttribute("users", listUsers);

        return "admin/list";
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.GET)
    public String addPage(){
        return "admin/add";
    }

    @RequestMapping(value = "admin/add", method = RequestMethod.POST)
    public String addUser( @ModelAttribute("user") User user,
                           @RequestParam(value = "rolSet") List<String> rolesName
//                           @RequestParam(value = "roleSet") String rolesName
    ){
        Set<Role> roleSet = new HashSet<>();
        for (String string: rolesName) {
            Role role1 = roleService.findRoleByName(string);
            roleSet.add(role1);
        }

//        Role role1 = roleService.findRoleByName(rolesName);
//        Role role1 = roleService.findRoleByName(rolesName);

//                user.getRoleSet().addAll(role1);

//       roleSet.addAll( user.getRoleSet().add(role1));
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.addAll(role1);
        user.setRoleSet(roleSet);

//        user.getRoleSet().addAll(role1);


        if (userService.findUserByEmail(user.getEmail()) == null){
            userService.create(user);

            return "redirect:/admin/list";
        } else {
            return "/userExists";
        }
    }

    @RequestMapping(value = "admin/edit/{id}",  method = RequestMethod.GET)
    public String editPage(@PathVariable("id") long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "admin/edit";
    }
    @RequestMapping(value = "admin/edit", method = RequestMethod.POST)
    public String editUser(
            @ModelAttribute("user") User user,
                           @RequestParam(value = "roleSet") List<String> rolesName
//            @RequestParam(value = "rolSet") String rolesName
//    @ModelAttribute("role") Role role
    )
    {
        //Добавление к уже существующей роли(1+1)
//        User user1 = userService.findUserById(user.getId());
////        List<Role> role1 = roleService.findRoleByName(rolesName);
//        Role role1 = roleService.findRoleByName(rolesName);
//        Set<Role> roleSet = new HashSet<>();
//        user1.getRoleSet().add(role1);
//        user=user1;

//        roleSet.add(role1);
//user.setRoleSet(roleSet);

        //Установка новых ролей
        Set<Role> roleSet = new HashSet<>();
        for (String string: rolesName) {
            Role role1 = roleService.findRoleByName(string);
            roleSet.add(role1);
        }
        user.setRoleSet(roleSet);
        if(userService.findUserByEmail(user.getEmail()) == null || userService.findUserByEmail(user.getEmail()).getId().equals(user.getId())){
            userService.update(user);
            return "redirect:/admin/list";
        } else {
            return "redirect:/userExists";
        }
    }

    @RequestMapping(value = "admin/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id){
        User user = userService.findUserById(id);
        userService.delete(user);
        return "redirect:/admin/list";
    }

    @RequestMapping(value="/login" , method = RequestMethod.GET)
    public String loginPage(@ModelAttribute("role") Role role) {
//        Role role = new Role();
        if (roleService.allRoles().isEmpty()) {
            roleService.add(role);
        }
        return "login";
    }
    @RequestMapping(value="/logout" , method = RequestMethod.GET)
    public String logoutPage(
//            @ModelAttribute("role") Role role,
//                            @ModelAttribute("user") User user
                            )
    {
//        Role role = new Role();
//        if (role != null || user != null) {
//            (role);
//        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/user",  method = RequestMethod.GET)
    public String userPage( Model model
    )
    {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);

        return "user/edit";
    }
}
