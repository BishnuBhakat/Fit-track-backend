package com.code.FitnessApp.controllers;


import com.code.FitnessApp.DTO.GoalRequest;
import com.code.FitnessApp.models.Goal;
import com.code.FitnessApp.models.User;
import com.code.FitnessApp.services.IGoalService;
import com.code.FitnessApp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//hello
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/goal/")
public class GoalControllers {
    @Autowired
    IGoalService goalService;
    @Autowired
    private IUserService userService;
    @RequestMapping(value="test")
    public String testingApi()
    {
        return "Welcome To API for Goal";
    }
    @GetMapping(value="/")
    public List<Goal> getAllGoal(@RequestParam String username){
        User user = userService.findByName(username);
        return goalService.getAll(user);
    }
    @PostMapping(value = "add")
    public ResponseEntity<String> addGoal(@RequestBody GoalRequest request) {
        User user=userService.findByName((request.getUsername()));
       Goal goal=request.getGoal();
        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid user.");
        }
       goal.setUser(user);
         goalService.addGoal(goal);
        return ResponseEntity.ok("goal added successfully.");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateGoal(@PathVariable Long id, @RequestBody Goal updatedGoal) {
        try {
            goalService.updateGoal(id, updatedGoal);
            return ResponseEntity.ok("Goal updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error updating goal: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGoal(@PathVariable Long id) {
        boolean isDeleted = goalService.deleteGoal(id);
        if (isDeleted) {
            return ResponseEntity.ok("Goal deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Goal not found");
        }
    }
}
