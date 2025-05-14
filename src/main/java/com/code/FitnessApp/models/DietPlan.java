package com.code.FitnessApp.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DietPlan")
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "date",nullable = false,length = 50)
    private String date;
    @Column(name = "dietType",nullable = false,length = 50)
    private String dietType;// breakfast lunch snacks dinner
    @Column(name = "description",nullable = false,length = 200)
    private String description;// meals description
    @Column(name = "calories",nullable = false)
    private int calories;//calories per dietType
    @Column(name = "nutrition",nullable = false,length = 100)
    private String nutrition;// carbs,proteins,fats
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

