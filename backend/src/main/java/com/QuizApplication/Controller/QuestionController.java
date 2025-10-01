package com.QuizApplication.Controller;

import com.QuizApplication.dto.QuestionRequestObject;
import com.QuizApplication.dto.QuestionUpdateRequest;
import com.QuizApplication.entities.Question;
import com.QuizApplication.exceptions.QuestionNotFoundException;
import com.QuizApplication.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("getQuestions")
    public ResponseEntity<List<Question>> getQuestions()
    {
        // the return statements returns all the questions and the status 200 when a request happens
        return new ResponseEntity<>(questionService.getQuestions(),HttpStatus.OK);
    }

    @GetMapping("getQuestion/{questionId}")
    public ResponseEntity<Question> getQuestion(@PathVariable long questionId)
    {
        // In case the questions found by the questionId the question will be returned with status ok in the other case an exception not found 404
        return new ResponseEntity<>(questionService.getQuestion(questionId), HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
    {
        //the return statements returns all the questions related to the specific category and the status 200 when a request happens
        return new ResponseEntity<>(questionService.getQuestionsByCategory(category), HttpStatus.OK);
    }

    @PostMapping("addquestion")
    public ResponseEntity<Question> addQuestion(@Validated @RequestBody QuestionRequestObject questionRequestObject)
    {
        //the return statements returns The new created Obj and the status code 201
        return new ResponseEntity<>(questionService.addQuestion(questionRequestObject), HttpStatus.CREATED);
    }

    @PutMapping("editquestion/{questionId}")
    public ResponseEntity<Question> editQuestion(@Validated @RequestBody QuestionUpdateRequest updateRequest, @PathVariable long questionId)
    {
        //the return statements returns The edited Obj and the status code 200
        return new ResponseEntity<>(questionService.editQuestion(updateRequest, questionId), HttpStatus.OK );
    }

    @DeleteMapping("deletequestion/{questionId}")
    public ResponseEntity<Boolean> deleteQuestion(@PathVariable long questionId)
    {
        //the return statements returns True and the status code 204, when  the deletion happens Successfully
        return new ResponseEntity<>(questionService.deleteQuestion(questionId), HttpStatus.NO_CONTENT);
    }
    
}
