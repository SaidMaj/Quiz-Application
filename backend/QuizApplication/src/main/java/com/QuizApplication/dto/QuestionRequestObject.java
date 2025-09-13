package com.QuizApplication.dto;

import com.QuizApplication.validation.DifficultyLevelValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequestObject {

    //I am validating userRequest Ensuring it not blank and validate the question title
    @NotBlank(message = "question title must not be blank or empty or null")
    @Size(min = 10, max = 120 , message = "the questionTitle length must be in between 20 and 120, not more than 120 or less 20")
    private String questionTitle;

    //I am validating options 1 - 4 and rightAnswer Ensuring it not blank and length is not less than 20 and not greater than 350
    @NotBlank(message = "option1 must not be blank or empty or null")
    @Size(min = 1, max = 350 , message = "the option1 length must be in between 1 and 350, not more than 350 or less 1")
    private String option1;

    @NotBlank(message = "option2 must not be blank or empty or null")
    @Size(min = 1, max = 350 , message = "the option2 length must be in between 1 and 350, not more than 350 or less 1")
    private String option2;

    @NotBlank(message = "option3 must not be blank or empty or null")
    @Size(min = 1, max = 350 , message = "the option3 length must be in between 1 and 350, not more than 350 or less 1")
    private String option3;

    @NotBlank(message = "option4 must not be blank or empty or null")
    @Size(min = 1, max = 350 , message = "the option4 length must be in between 1 and 350, not more than 350 or less 1")
    private String option4;

    @NotBlank(message = "rightAnswer must not be blank or empty or null")
    @Size(min = 1, max = 350 , message = "the rightAnswer length must be in between 1 and 350, not more than 350 or less 1")
    private String rightAnswer;

    @DifficultyLevelValidation
    private String difficultyLevel;

    @Size(min = 1, max = 50 , message = "the rightAnswer length must be in between 1 and 50, not more than 50 or less 1")
    @NotBlank
    private String category;
}
