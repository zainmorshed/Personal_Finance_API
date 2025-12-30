package com.finance.service;

import java.util.List;
import com.finance.entity.User;

public interface UserService {

    User createUser(User user);
    List<User> getUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
    User getUserByName(String name);
    
}
