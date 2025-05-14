package com.code.FitnessApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Goal")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "date", nullable = false, length = 50)
    private String date;//for setting the starting of the goal
    @Column(name = "goal", nullable = false, length = 100)
    private String goal;//there will be 3 goal levels - muscle-build,weight-loss,fit&healthy
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
