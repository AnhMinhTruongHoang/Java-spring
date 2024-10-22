package vn.hoidanit.laptopshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "hello";
    }
    ////////////////////////////////////////////////////////////////////////
    @RequestMapping("/admin/user/create")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    
   @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User userdb) {
        this.userService.handleSaveUser(userdb);
        return "redirect:/admin/user";
    }
    /////////////////////////////////////

    @RequestMapping("/admin/user")
    public String UserList(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users1", users);
        System.out.println(">>>"+ users);
        return "admin/user/Table-User";
    }
    //////////////// view user
    @RequestMapping("/admin/user/{id}")
    public String GetUserDetail(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
       
       
        return "admin/user/User-View";
    }

    // @RequestMapping("/admin/user/{id}")
    // public String UpdateUser(Model model, @PathVariable Long id) {
    //     User user = this.userService.getUserById(id);
    //     model.addAttribute("user", user);
    //     model.addAttribute("id", id);
       
       
    //     return "admin/user/User-Update";
    // }
    


}
