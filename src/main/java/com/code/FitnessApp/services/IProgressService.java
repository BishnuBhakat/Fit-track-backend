package com.code.FitnessApp.services;

import com.code.FitnessApp.models.Progress;
import com.code.FitnessApp.models.User;

import java.util.List;

public interface IProgressService {
    public boolean deleteProgress(long id);
    public void addProgress(Progress progress);
    public void updateProgress(Progress progress);
    public List<Progress> getAll(User user);
}
