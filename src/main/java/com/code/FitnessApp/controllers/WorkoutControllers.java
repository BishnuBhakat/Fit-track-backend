package com.code.FitnessApp.controllers;

import com.code.FitnessApp.DTO.WorkoutRequest;
import com.code.FitnessApp.models.User;
import com.code.FitnessApp.models.Workout;
import com.code.FitnessApp.services.IUserService;
import com.code.FitnessApp.services.IWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/workout/")
public class WorkoutControllers {
    @Autowired
    IWorkoutService workoutService;
    @Autowired
    IUserService userService;
    @RequestMapping(value="test")
    public String testingApi()
    {
        return "Welcome To API for Workout";
    }
    @GetMapping(value = "/")
    public ResponseEntity<List<Workout>> getAllWorkout(@RequestParam String username){
        User user=userService.findByName(username);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(workoutService.getAll(user)) ;
    }
    @PostMapping(value = "add")
    public ResponseEntity<String> addWorkout(@RequestBody WorkoutRequest request) {
        User user = userService.findByName(request.getUsername());
        Workout workout=request.getWorkout();
        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid user.");
        }
        workout.setUser(user);
        workoutService.addWorkout(workout);
        return ResponseEntity.ok("Workout added successfully.");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWorkout(@PathVariable Long id) {
      boolean deleted=  workoutService.deleteWorkout(id);
        if (deleted) {
            return ResponseEntity.ok("Workout deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workout not found");
        }
    }
}