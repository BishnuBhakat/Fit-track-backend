// ProgressRequest.java
package com.code.FitnessApp.DTO;

import com.code.FitnessApp.models.Progress;
import lombok.Data;

@Data
public class ProgressRequest {
    private String username;
    private Progress progress;
}

