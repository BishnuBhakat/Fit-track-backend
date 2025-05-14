package com.code.FitnessApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Workout")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "date",nullable = false,length = 50)
    private String date;
    @Column(name = "exerciseName",nullable = false,length = 50)
    private String exerciseName;
    @Column(name = "sets",nullable = false)
    private int sets;
    @Column(name = "reps",nullable = false)
    private int reps;
    @Column(name = "calories_burned",nullable = false)
    private int calories_burned;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
