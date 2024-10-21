package vn.hoidanit.laptopshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.hoidanit.laptopshop.Model.User;
import vn.hoidanit.laptopshop.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserService userService;
   
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        User arrUsers = this.userService.getAllUserByEmail("1@gmail.com");
        
        System.out.println(arrUsers);
        return "hello";
    }
    ////////////////////////////////////////////////////////////////////////
    @RequestMapping("/admin/user/create")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    
   @RequestMapping(value = "/admin/user", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User userdb) {
       
        this.userService.handleSaveUser(userdb);
        return "hello";
    }
    /////////////////////////////////////

    @RequestMapping("/admin/user")
    public String UserList(Model model) {
        return "admin/user/Table-User";
    }
    



}
