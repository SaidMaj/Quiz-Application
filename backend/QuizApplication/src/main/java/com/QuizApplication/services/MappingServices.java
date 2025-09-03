package com.QuizApplication.services;

import com.QuizApplication.dto.QuestionRequestObject;
import com.QuizApplication.dto.QuestionUpdateRequest;
import com.QuizApplication.entities.Question;
import com.QuizApplication.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingServices {


    @Autowired
    private QuestionRepository questionRepository;

   public Question convertDTOToQuestionObject(QuestionRequestObject questionRequestObject, Question question)
   {

       question.setCategory(questionRequestObject.getCategory());
       question.setDifficultyLevel(questionRequestObject.getDifficultyLevel());
       question.setOption1(questionRequestObject.getOption1());
       question.setOption2(questionRequestObject.getOption2());
       question.setOption3(questionRequestObject.getOption3());
       question.setOption4(questionRequestObject.getOption4());
       question.setQuestionTitle(questionRequestObject.getQuestionTitle());
       question.setRightAnswer(questionRequestObject.getRightAnswer());

       return question;
   }

   public Question convertDTOToQuestionObject(QuestionUpdateRequest questionUpdateRequest, Question question)
   {

       question.setCategory(questionUpdateRequest.getCategory());
       question.setDifficultyLevel(questionUpdateRequest.getDifficultyLevel());
       question.setOption1(questionUpdateRequest.getOption1());
       question.setOption2(questionUpdateRequest.getOption2());
       question.setOption3(questionUpdateRequest.getOption3());
       question.setOption4(questionUpdateRequest.getOption4());
       question.setQuestionTitle(questionUpdateRequest.getQuestionTitle());
       question.setRightAnswer(questionUpdateRequest.getRightAnswer());

       return question;
   }

}
