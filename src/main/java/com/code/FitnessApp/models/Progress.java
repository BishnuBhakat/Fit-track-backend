package com.code.FitnessApp.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Progress")
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "calories_intake",nullable = false)
    private int calories_intake;
    @Column(name = "calories_burnt",nullable = false)
    private int calories_burnt;
    @Column(name = "date",nullable = false,length = 50)
    private String date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
