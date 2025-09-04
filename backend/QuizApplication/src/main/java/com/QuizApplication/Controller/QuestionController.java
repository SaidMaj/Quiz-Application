package com.QuizApplication.Controller;

import com.QuizApplication.dto.QuestionRequestObject;
import com.QuizApplication.dto.QuestionUpdateRequest;
import com.QuizApplication.entities.Question;
import com.QuizApplication.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("getQuestions")
    public List<Question> getQuestions()
    {
        return questionService.getQuestions();
    }


    @GetMapping("getQuestion/{questionId}")
    public Optional<Question> getQuestion(@PathVariable long questionId)
    {
        return questionService.getQuestion(questionId);
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);
    }


    @PostMapping("addquestion")
    public Question addQuestion(@RequestBody QuestionRequestObject questionRequestObject)
    {
        // I have used the return beacuse once the object crated the user can see it
        return questionService.addQuestion(questionRequestObject);
    }

    @PutMapping("editquestion/{questionId}")
    public Question editQuestion(@RequestBody QuestionUpdateRequest updateRequest, @PathVariable long questionId)
    {
        return questionService.editQuestion(updateRequest, questionId);
    }

    @DeleteMapping("deletequestion/{questionId}")
    public boolean deleteQuestion(@PathVariable long questionId)
    {
        return questionService.deleteQuestion(questionId);
    }
    
}
