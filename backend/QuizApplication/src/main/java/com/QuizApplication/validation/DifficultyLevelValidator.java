package com.QuizApplication.validation;
import com.QuizApplication.entities.difficulty;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

import static com.QuizApplication.Utilites.StringUtility.capitalizeWord;

public class DifficultyLevelValidator implements ConstraintValidator<DifficultyLevelValidation, String> {
    @Override
    public void initialize(DifficultyLevelValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String difficultyLevel, ConstraintValidatorContext constraintValidatorContext) {

        //Here I have declared an Array List
        List<String> levels = new ArrayList<String>();

        //here I will loop throw enum values I called them using the value() method
        //it will go throw them convert It to String then capitalize it add it
        for(difficulty level : difficulty.values())
         {
             levels.add(capitalizeWord(level.name()));
         }

        return levels.contains(difficultyLevel.toUpperCase());
    }


}
