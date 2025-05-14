package com.code.FitnessApp.repository;

import com.code.FitnessApp.models.Progress;
import com.code.FitnessApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProgressRepository extends JpaRepository<Progress,Long> {
    List<Progress> findByUser(User user);
}
