package com.evalutation.cartcrud.controller;

import com.evalutation.cartcrud.dto.LoginDto;
import com.evalutation.cartcrud.model.User;
import com.evalutation.cartcrud.response.Api;
import com.evalutation.cartcrud.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Api(e.getMessage(), null));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto user) {
        try {
            return ResponseEntity.ok(userService.login(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Api(e.getMessage(), null));
        }
    }

}
