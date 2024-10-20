package vn.hoidanit.laptopshop.service;

import java.util.List;
import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.Model.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

        public String handleHello(){
            return "hello service";
        }

    public List<User> getAllUser(){
        return this.userRepository.findAll();
    }
    public User getAllUserByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public User handleSaveUser(User user){
        User allUser = this.userRepository.save(user);
        System.out.println(allUser);
        return allUser;
       
    }
       
}
