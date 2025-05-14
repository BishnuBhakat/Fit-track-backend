package com.code.FitnessApp.repository;

import com.code.FitnessApp.models.User;
import com.code.FitnessApp.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWorkoutRepository extends JpaRepository<Workout,Long> {
    List<Workout> findByUser(User user);
}
