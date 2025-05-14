package com.code.FitnessApp.services;

import com.code.FitnessApp.models.Progress;
import com.code.FitnessApp.models.User;
import com.code.FitnessApp.repository.IProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressService implements IProgressService {
    @Autowired
    IProgressRepository progressRepo;


    @Override
    public boolean deleteProgress(long id) {
        Optional<Progress> progress = progressRepo.findById(id);
        if (progress.isPresent()) {
            progressRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void addProgress(Progress progress) {
    progressRepo.save(progress);
    }

    @Override
    public void updateProgress(Progress progress) {
        progressRepo.save(progress);
    }

    @Override
    public List<Progress> getAll(User user) {
        return progressRepo.findByUser(user);
    }
}

