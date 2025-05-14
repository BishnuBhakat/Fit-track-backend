package com.code.FitnessApp.controllers;

import com.code.FitnessApp.DTO.ProgressRequest;
import com.code.FitnessApp.models.Progress;
import com.code.FitnessApp.models.User;
import com.code.FitnessApp.services.IProgressService;
import com.code.FitnessApp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/progress/")
public class ProgressControllers {
    @Autowired
    IProgressService progressService;
    @Autowired
    IUserService userService;
    @RequestMapping(value="test")
    public String testingApi()
    {
        return "Welcome To API for Progress";
    }
    @GetMapping(value = "/")
    public ResponseEntity<List<Progress>> getAll(@RequestParam String username){
        User user=userService.findByName(username);
        if (user == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(progressService.getAll(user));
    }
    @PostMapping(value = "add")
    public ResponseEntity<String> addProgress(@RequestBody ProgressRequest request) {
        User user = userService.findByName(request.getUsername());
        Progress progress=request.getProgress();
        if (user == null) return ResponseEntity.badRequest().body("Invalid user");
        progress.setUser(user);
        progressService.addProgress(progress);
        return ResponseEntity.ok("Progress added successfully");
    }
    @PutMapping(value = "update")
    public ResponseEntity<String> updateProgress(@RequestBody Progress progress, @RequestParam String username) {
        User user = userService.findByName(username);
        if (user == null) return ResponseEntity.badRequest().body("Invalid user");
        progress.setUser(user);
        progressService.updateProgress(progress);
        return ResponseEntity.ok("Progress updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProgress(@PathVariable Long id) {
        boolean deleted = progressService.deleteProgress(id);
        if (deleted) {
            return ResponseEntity.ok("Progress deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Progress not found");
        }
    }
}
