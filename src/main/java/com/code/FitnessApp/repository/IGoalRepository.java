package com.code.FitnessApp.repository;

import com.code.FitnessApp.models.DietPlan;
import com.code.FitnessApp.models.Goal;
import com.code.FitnessApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGoalRepository extends JpaRepository<Goal,Long> {
    List<Goal> findByUser(User user);
}