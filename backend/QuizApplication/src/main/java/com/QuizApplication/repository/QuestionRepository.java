package com.QuizApplication.repository;

import com.QuizApplication.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    //I have crated this to find all question that related to on category
    List<Question> findAllByCategory(String category);

    //I have created to following to avoid duplication

    boolean existsByQuestionTitle(String questionTitle);
}
