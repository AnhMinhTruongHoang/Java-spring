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
    public List<User> getAllUsersByEmail(String email){
        return this.userRepository.findOneByEmail(email);
    }
    public User getUserById(Long id){
        return this.userRepository.findUserById(id);
    }

    public User handleSaveUser(User user){
        User allUser = this.userRepository.save(user);
        return allUser;
       
    }

    public void deleteAUser(long id){
         this.userRepository.deleteById(id);;
    }
    
       
}
