package com.QuizApplication.services;

import com.QuizApplication.dto.QuestionRequestObject;
import com.QuizApplication.entities.Question;
import org.springframework.stereotype.Service;

@Service
public class MappingServices {

   public Question convertDTOToQuestionObject(QuestionRequestObject questionRequestObject)
   {
       Question question = new Question();

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
}
