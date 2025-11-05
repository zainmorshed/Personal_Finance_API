package com.finance.service;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.finance.Repo.UserRepository;
import com.finance.entity.User;

@Service
@Primary
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    
}
/*
 * we need to create a new userRepository object so that...
 * we can call the sql methods on the object using the ...
 * methods that we declared from the UserService class
 */
