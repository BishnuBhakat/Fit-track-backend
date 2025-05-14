// DietRequest.java
package com.code.FitnessApp.DTO;

import com.code.FitnessApp.models.DietPlan;
import lombok.Data;

@Data
public class DietRequest {
    private String username;
    private DietPlan dietplan;
}
