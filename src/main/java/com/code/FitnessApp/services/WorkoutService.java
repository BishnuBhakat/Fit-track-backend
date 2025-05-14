package com.code.FitnessApp.services;

import com.code.FitnessApp.models.User;
import com.code.FitnessApp.models.Workout;
import com.code.FitnessApp.repository.IGoalRepository;
import com.code.FitnessApp.repository.IWorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService implements IWorkoutService {
    @Autowired
    IWorkoutRepository workoutRepo;


    @Override
    public void addWorkout(Workout workout) {
        workoutRepo.save(workout);
    }

    @Override
    public boolean deleteWorkout(long id) {
        Optional<Workout> workout=workoutRepo.findById(id);
        if (workout.isPresent()) {
            workoutRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Workout> getAll(User user) {
        return workoutRepo.findByUser(user);
    }
}

