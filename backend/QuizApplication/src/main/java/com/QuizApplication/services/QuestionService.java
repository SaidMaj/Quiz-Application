package com.QuizApplication.services;

import com.QuizApplication.entities.Question;
import com.QuizApplication.repository.QuestionRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestions()
    {
        //I have crated this list to store the questions
        List <Question> questions = new ArrayList<>();

        //this Range-loop loops through all the questions and add question one by one
        for (Question question : questionRepository.findAll())
        {
            questions.add(question);
        }

        return questions;
    }
}
