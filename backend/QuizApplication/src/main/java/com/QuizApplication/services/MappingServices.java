package com.QuizApplication.services;

import com.QuizApplication.dto.QuestionRequestObject;
import com.QuizApplication.dto.QuestionUpdateRequest;
import com.QuizApplication.dto.QuizDto;
import com.QuizApplication.dto.QuizQuestionDto;
import com.QuizApplication.entities.Question;
import com.QuizApplication.entities.Quiz;
import com.QuizApplication.entities.difficulty;
import com.QuizApplication.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.QuizApplication.Utilites.StringUtility.capitalizeWord;

@Service
public class MappingServices {


    @Autowired
    private QuestionRepository questionRepository;

   public Question convertDTOToQuestionObject(QuestionRequestObject questionRequestObject, Question question)
   {

       question.setCategory(questionRequestObject.getCategory());
       question.setDifficultyLevel(difficulty.valueOf(capitalizeWord(questionRequestObject.getDifficultyLevel())));
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
       question.setDifficultyLevel(difficulty.valueOf(capitalizeWord(questionUpdateRequest.getDifficultyLevel())));
       question.setOption1(questionUpdateRequest.getOption1());
       question.setOption2(questionUpdateRequest.getOption2());
       question.setOption3(questionUpdateRequest.getOption3());
       question.setOption4(questionUpdateRequest.getOption4());
       question.setQuestionTitle(questionUpdateRequest.getQuestionTitle());
       question.setRightAnswer(questionUpdateRequest.getRightAnswer());

       return question;
   }



    public QuizDto convertingQuizToDto(Quiz quiz)
    {
        QuizDto quizDto = new QuizDto();
        quizDto.setQuizId(quiz.getQuizId());
        quizDto.setQuizTitle(quiz.getQuizTitle());
        quizDto.setCategory(quiz.getCategory());
        quizDto.setNumberOfQuestions(quiz.getNumberOfQuestions());
        quizDto.setDifficultyLevel(quiz.getDifficultyLevel());

        return  quizDto;
    }

    //Here I am converting question objct to safe type to show the necessary data such as question title,  the options
    public QuizQuestionDto convertQuestionToQuizQuestionDto(Question question )
    {
        QuizQuestionDto quizQuestionDto = new QuizQuestionDto();

        quizQuestionDto.setId(question.getId());
        quizQuestionDto.setQuestionTitle(question.getQuestionTitle());
        quizQuestionDto.setOption1(question.getOption1());
        quizQuestionDto.setOption2(question.getOption2());
        quizQuestionDto.setOption3(question.getOption3());
        quizQuestionDto.setOption4(question.getOption4());

        return quizQuestionDto;
    }

}
