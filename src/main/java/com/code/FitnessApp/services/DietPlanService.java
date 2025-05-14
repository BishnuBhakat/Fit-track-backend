package com.code.FitnessApp.services;


import com.code.FitnessApp.models.DietPlan;
import com.code.FitnessApp.models.User;
import com.code.FitnessApp.repository.IDietPlanRepository;
import com.code.FitnessApp.repository.IGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietPlanService implements IDietPlanService{
    @Autowired
    IDietPlanRepository dietRepo;

    @Override
    public boolean deleteDietPlan(long id) {
        Optional<DietPlan> diet=dietRepo.findById(id);
        if(diet.isPresent()){
       dietRepo.deleteById(id);
       return true;
    }else {
            return false;
        }
}

    @Override
    public void addDietPlan(DietPlan dietPlan) {
    dietRepo.save(dietPlan);
    }

    @Override
    public List<DietPlan> getAll(User user) {
       return dietRepo.findByUser(user);
    }
}
