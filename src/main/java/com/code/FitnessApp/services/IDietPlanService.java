package com.code.FitnessApp.services;

import com.code.FitnessApp.models.DietPlan;
import com.code.FitnessApp.models.User;

import java.util.List;

public interface IDietPlanService {
    public boolean deleteDietPlan(long id);
    public void addDietPlan(DietPlan dietPlan);
    public List<DietPlan> getAll(User user);
}
