package com.QuizApplication.services;

import com.QuizApplication.dto.QuestionRequestObject;
import com.QuizApplication.dto.QuestionUpdateRequest;
import com.QuizApplication.entities.Question;
import com.QuizApplication.repository.QuestionRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private MappingServices mappingServices;

    public List<Question> getQuestions()
    {
        // returns all the questions
        return questionRepository.findAll();
    }

    public Question addQuestion(QuestionRequestObject questionRequestObject)
    {
        //Here I have declared a new question to add the dto value to it
        Question question = new Question();

        //Here the code first convert DTO to OBJ then it save it in the database after that it returned to the user
        return questionRepository.save(mappingServices.convertDTOToQuestionObject(questionRequestObject, question));
    }

    public Question editQuestion(QuestionUpdateRequest updateRequest, long questionId) {

        //Here I used an method from the repo to get me a specific question by using the questionId
        Question question = questionRepository.getById(questionId);

        //Here the first DTO converted to question Service, after that it saved to the database
        return questionRepository.save(mappingServices.convertDTOToQuestionObject(updateRequest, question));
    }

    public boolean deleteQuestion(long questionId) {
        //I have called the deleteById method to delete the question from the database
        questionRepository.deleteById(questionId);

        return true;
    }

    public Optional<Question> getQuestion(long questionId) {
        return questionRepository.findById(questionId);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findAllByCategory(category);
    }
}
