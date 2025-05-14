package com.code.FitnessApp.controllers;

import com.code.FitnessApp.DTO.LoginRequest;
import com.code.FitnessApp.DTO.RegisterRequest;
import com.code.FitnessApp.models.User;
import com.code.FitnessApp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/users/")
public class UserControllers {
    @Autowired
    IUserService userService;
    @RequestMapping(value="test")
    public String testingApi()
    {
        return "Welcome To  API for User";
    }
    @GetMapping(value = "/")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @PostMapping(value = "login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        boolean valid = userService.validateUser(request);
        if (valid) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }
    @PostMapping(value = "register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(userService.registerUser(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("user deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
    }
}

