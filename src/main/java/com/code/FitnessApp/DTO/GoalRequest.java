// GoalRequest.java
package com.code.FitnessApp.DTO;

import com.code.FitnessApp.models.Goal;
import lombok.Data;

@Data
public class GoalRequest {
    private String username;
    private Goal goal;
}

