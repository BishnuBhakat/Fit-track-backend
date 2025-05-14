package com.code.FitnessApp.services;

import com.code.FitnessApp.DTO.LoginRequest;
import com.code.FitnessApp.DTO.RegisterRequest;
import com.code.FitnessApp.models.Goal;
import com.code.FitnessApp.models.User;
import com.code.FitnessApp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepo;


    @Override
    public String registerUser(RegisterRequest request) {
        User user= new User();
        user.setName(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepo.save(user);
        return "User registered successfully!";
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User findByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public boolean deleteUser(long id) {

            Optional<User> user = userRepo.findById(id);
            if (user.isPresent()) {
                userRepo.deleteById(id);
                return true;
            } else {
                return false;
            }
        }

    @Override
    public boolean validateUser(LoginRequest request) {
        User user = userRepo.findByName(request.getUsername());
        return user != null && user.getPassword().equals(request.getPassword());
    }


}
