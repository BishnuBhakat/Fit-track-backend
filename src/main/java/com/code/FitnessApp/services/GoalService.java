package com.code.FitnessApp.services;

import com.code.FitnessApp.models.Goal;
import com.code.FitnessApp.models.User;
import com.code.FitnessApp.repository.IGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService implements IGoalService {
    @Autowired
    IGoalRepository goalRepo;

    @Override
    public Goal addGoal(Goal goal) {
      return  goalRepo.save(goal);
    }

    @Override
    public boolean deleteGoal(long id) {
        Optional<Goal> goal = goalRepo.findById(id);
        if (goal.isPresent()) {
            goalRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Goal updateGoal(Long id, Goal updatedGoal) {
        Optional<Goal> optionalGoal = goalRepo.findById(id);
        if (optionalGoal.isPresent()) {
            Goal goal = optionalGoal.get();
            goal.setDate(updatedGoal.getDate());
            goal.setGoal(updatedGoal.getGoal());
            return goalRepo.save(goal);
        }
        return null;
    }

    @Override
    public List<Goal> getAll(User user) {
        return goalRepo.findByUser(user);
    }
}
