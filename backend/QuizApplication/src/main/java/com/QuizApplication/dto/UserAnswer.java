package com.QuizApplication.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswer {
    private long questionId;
    @NotBlank(message = "The Answer Must Not be Blank")
    private String userAnswer;
}
