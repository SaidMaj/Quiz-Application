package com.QuizApplication.repository;

import com.QuizApplication.entities.Question;
import com.QuizApplication.entities.difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    //I have crated this to find all question that related to on category
    //I have created this to fetch question by category and without any specific difficultyLevel
    List<Question> findAllByCategory(String category);

    //I have created to following to avoid duplication
    boolean existsByQuestionTitle(String questionTitle);

    //I have created this to fetch question by category and specific difficultyLevel
    List<Question> findAllByCategoryAndDifficultyLevel(String category, difficulty difficultyLevel);

    //I have created this to fetch  difficultyLevel and all the categories
    List<Question> findAllByDifficultyLevel(difficulty difficultyLevel);

}
