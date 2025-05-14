package com.code.FitnessApp.services;

import com.code.FitnessApp.models.User;
import com.code.FitnessApp.models.Workout;

import java.util.List;

public interface IWorkoutService {
    public void addWorkout(Workout workout);
    public boolean deleteWorkout(long id);
    public List<Workout> getAll(User user);
}