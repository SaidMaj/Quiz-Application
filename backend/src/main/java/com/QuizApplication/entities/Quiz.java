package com.QuizApplication.entities;

import com.QuizApplication.dto.QuizQuestionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Quiz {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long quizId;

    private String quizTitle;
    private String category;
    private int numberOfQuestions;
    private String difficultyLevel;

    @ManyToMany
    List<Question> Questions;
}
