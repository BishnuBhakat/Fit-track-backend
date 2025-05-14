package com.code.FitnessApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", unique = true,nullable = false,length = 50)
    private String name;
    @Column(name = "email", unique = true,nullable = false,length = 50)
    private String email;
    @Column(name = "password",nullable = false,length = 20)
    private String password;

}
