package com.code.FitnessApp.services;

import com.code.FitnessApp.models.Goal;
import com.code.FitnessApp.models.User;

import java.util.List;

public interface IGoalService {
    public Goal addGoal(Goal goal);
    public boolean deleteGoal(long id);
    public Goal  updateGoal(Long id, Goal updatedGoal);//here edit is applicable because if after ex-fit he want to build muscle then gol can be edited
    public List<Goal> getAll(User user);

}
