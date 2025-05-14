package com.code.FitnessApp.repository;

import com.code.FitnessApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
     User findByName(String name);
}
