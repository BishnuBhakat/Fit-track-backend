// WorkoutRequest.java
package com.code.FitnessApp.DTO;

import com.code.FitnessApp.models.Workout;
import lombok.Data;

@Data
public class WorkoutRequest {
    private String username;
    private Workout workout;
}
