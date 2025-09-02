package com.QuizApplication.services;

import com.QuizApplication.dto.QuestionRequestObject;
import com.QuizApplication.dto.QuestionUpdateRequest;
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
    @Autowired
    private MappingServices mappingServices;

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

    public Question addQuestion(QuestionRequestObject questionRequestObject)
    {
        // I have called the mappingServices to convert the DTO the Obj to store it in the question database
        Question question = mappingServices.convertDTOToQuestionObject(questionRequestObject);
        questionRepository.save(question);
        return question;
    }

    public Question editQuestion(QuestionUpdateRequest updateRequest, long questionId) {
        //I have called mappingServices to update the Question Obj using The UpdateRequest DTO and I used questionId to find specific question
        return questionRepository.save(mappingServices.updateQuestionObject(updateRequest, questionId));
    }
}
