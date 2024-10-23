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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




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
    //////////////////////// create
    @RequestMapping("/admin/user/create")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    //////////////////////// create button
   @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User userdb) {
        this.userService.handleSaveUser(userdb);
        return "redirect:/admin/user";
    }
    ///////////////////////////////////// table user
    @RequestMapping("/admin/user")
    public String UserList(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users1", users);
        System.out.println(">>>"+ users);
        return "admin/user/Table-User";
    }
    //////////////// view user
    @RequestMapping(value = "/admin/user/{id}", method = RequestMethod.GET)
    public String GetUserDetail(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
       
        return "admin/user/User-View";
    }
    
   // Update user details
    @RequestMapping(value = "/admin/user/User-Update/{id}")
    public String UpdateUser(Model model, @PathVariable Long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        
        return "admin/user/User-Update";
}
    /////Update button
    @PostMapping("/admin/user/User-Update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User userdb) {
        User currentUser = this.userService.getUserById(userdb.getId());
        if(currentUser != null){
           currentUser.setFullName(userdb.getFullName());
           currentUser.setAddress(userdb.getAddress());
           currentUser.setPhone(userdb.getPhone());
           
           this.userService.handleSaveUser(currentUser);
        }
        
        return "redirect:/admin/user";
}   
    ///////////////////Delete user
    @GetMapping(value = "/admin/user/User-Delete/{id}")
    public String DeleteUser(Model model, @PathVariable long id) {
        // User user = new User();
        // user.setId(id);
        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());
        
        return "/admin/user/User-Delete";
}   
    //////////////delete button
    @PostMapping( value = "/admin/user/User-Delete")
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User deleteUser) {
            this.userService.deleteAUser(deleteUser.getId());
        
        return "redirect:/admin/user";
}

}
