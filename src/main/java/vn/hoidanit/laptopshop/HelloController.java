package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController { 
    
    @GetMapping("/")
        public String index() {
        return "Hello World from Spring Boot";
        } 
    @GetMapping("/user")
        public String userpage() {
        return "only user";
        } 
    @GetMapping("/admin")
        public String adminpage() {
        return "only admin";
        } 
}