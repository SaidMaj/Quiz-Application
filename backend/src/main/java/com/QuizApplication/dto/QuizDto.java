package com.QuizApplication.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

//I have created this quiz dto to show the necessary data only
public class QuizDto {
    private long quizId;

    private String quizTitle;
    private String category;
    private int numberOfQuestions;
    private String difficultyLevel;

}