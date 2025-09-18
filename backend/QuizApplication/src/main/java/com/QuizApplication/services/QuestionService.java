package com.QuizApplication.services;

import com.QuizApplication.dto.QuestionRequestObject;
import com.QuizApplication.dto.QuestionUpdateRequest;
import com.QuizApplication.entities.Question;
import com.QuizApplication.exceptions.QuestionAlreadyExistsException;
import com.QuizApplication.exceptions.QuestionNotFoundException;
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

        //Here I am checking if there is a question exists with the same given title
        if (questionRepository.existsByQuestionTitle(questionRequestObject.getQuestionTitle()))
        {
            throw new QuestionAlreadyExistsException("Question Already Exists with the following title : " + questionRequestObject.getQuestionTitle());
        }

        //Here the code first convert DTO to OBJ then it save it in the database after that it returned to the user
        return questionRepository.save(mappingServices.convertDTOToQuestionObject(questionRequestObject, question));
    }

    public Question editQuestion(QuestionUpdateRequest updateRequest, long questionId) {

        //Here I used an method from the repo to find me a specific question by using the questionId, in case the question not found an error will be thrown
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException("question with " + questionId + " Id not found"));

        //Here the first DTO converted to question Service, after that it saved to the database
        return questionRepository.save(mappingServices.convertDTOToQuestionObject(updateRequest, question));
    }

    public boolean deleteQuestion(long questionId) {

        //The if statement checks if there a question already exists by the given id in case no an exception will be thrown
        if (!questionRepository.existsById(questionId))
        {
            throw new QuestionNotFoundException("question with " + questionId + " Id not found");
        }

        //I have called the deleteById method to delete the question from the database
        questionRepository.deleteById(questionId);

        return true;
    }

    public Question getQuestion(long questionId)
    {
        /*
        * in case the question with Id found successfully it will return question
        * in the other case an exception will be thrown QuestionNotFoundException
        * */
        return questionRepository.findById(questionId).
                orElseThrow(() -> new QuestionNotFoundException("question with " + questionId + " Id not found"));
    }

    public List<Question> getQuestionsByCategory(String category) {

        //The following list stores all the question related to specific category
        return questionRepository.findAllByCategory(category);
    }
}
