package com.evalutation.cartcrud.services;

import com.evalutation.cartcrud.dto.LoginDto;
import com.evalutation.cartcrud.model.User;
import com.evalutation.cartcrud.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User registerUser(User user){
        if(userRepository.existsByEmailAndUsername(user.getEmail(), user.getUsername())){
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    public User login(LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUsername());
        if(user.getPassword().equals(loginDto.getPassword())){
            return user;
        }

        else{
            throw new RuntimeException("invalid credentials");
        }

    }
}
