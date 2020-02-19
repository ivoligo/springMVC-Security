package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String allUsers(Model model){
        List<User> listUsers = userService.getAllUser();
        List<User> listUsers1 = userService.getAllUsersWithRole();
        model.addAttribute("users", listUsers);

        return "list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addPage(){
        return "/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUser(
            @ModelAttribute("user")
                    User user,
            @ModelAttribute("role") Role role
    ){

        if (userService.findUserByEmail(user.getEmail()) == null){
            userService.create(user);
            if (role.getRolesName().equals("admin")
                    || role.getRolesName().equals("user")
                    || role.getRolesName().equals("webUser")
                    || role.getRolesName().equals("otherUser")){
                user.addRole(role);
            }
            return "redirect:/list";
        } else {
            return "/userExists";
        }

    }

    @RequestMapping(value = "/edit/{id}",  method = RequestMethod.GET)
    public String editPage(@PathVariable("id") long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user){
//        User user = userService.findUserById(id);
        if(userService.findUserByEmail(user.getEmail()) == null || userService.findUserByEmail(user.getEmail()).getId().equals(user.getId())){
            userService.update(user);
            return "redirect:/list";
        } else {
            return "redirect:/userExists";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id){
        User user = userService.findUserById(id);
        userService.delete(user);
        return "redirect:/list";
    }

    @RequestMapping(value="/login" , method = RequestMethod.GET)
    public String loginPage(@ModelAttribute("role") Role role ) {
//        Role role = new Role();
        if (roleService.allRoles().isEmpty()) {
            roleService.add(role);
        }
        return "login";
    }

}
