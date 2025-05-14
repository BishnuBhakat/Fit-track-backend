package com.code.FitnessApp.services;

import com.code.FitnessApp.DTO.LoginRequest;
import com.code.FitnessApp.DTO.RegisterRequest;
import com.code.FitnessApp.models.User;

import java.util.List;

public interface IUserService {
    String registerUser(RegisterRequest request);
    public List<User> getAll();
    User findByName(String name);
    public boolean deleteUser(long id);
    public boolean validateUser(LoginRequest request);//will be using this in controllers for mapping for login
}