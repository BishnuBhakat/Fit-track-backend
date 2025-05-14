package com.code.FitnessApp.controllers;

import com.code.FitnessApp.DTO.DietRequest;
import com.code.FitnessApp.models.DietPlan;
import com.code.FitnessApp.models.User;
import com.code.FitnessApp.services.IDietPlanService;
import com.code.FitnessApp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/dietplan/")
public class DietPlanControllers {
    @Autowired
    IDietPlanService dietPlanService;
    @Autowired
    IUserService userService;
    @RequestMapping(value="test")
    public String testingApi()
    {
        return "Welcome  To API for DietPlan";
    }
    @GetMapping(value = "/")
    public ResponseEntity<List<DietPlan>> getAll(@RequestParam String username) {
        User user = userService.findByName(username);
        if (user == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(dietPlanService.getAll(user));
    }
    @PostMapping(value = "add")
    public ResponseEntity <String> addDiet(@RequestBody DietRequest request) {
        User user = userService.findByName(request.getUsername());

        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid user.");
        }
        DietPlan diet =request.getDietplan();
        diet.setUser(user);
          dietPlanService.addDietPlan(diet);
          return ResponseEntity.ok("diet added successfully.");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDiet(@PathVariable Long id) {
       boolean deleted= dietPlanService.deleteDietPlan(id);
        if (deleted) {
            return ResponseEntity.ok("Diet plan deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Diet plan not found");
        }
    }
}
