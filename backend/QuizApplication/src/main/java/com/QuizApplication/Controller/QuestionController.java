package com.QuizApplication.Controller;

import com.QuizApplication.dto.QuestionRequestObject;
import com.QuizApplication.dto.QuestionUpdateRequest;
import com.QuizApplication.entities.Question;
import com.QuizApplication.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("getQuestions")
    public List<Question> questions()
    {
        return questionService.getQuestions();
    }

    @PostMapping("addquestion")
    public Question addQuestion(@RequestBody QuestionRequestObject questionRequestObject)
    {
        // I have used the return beacuse once the object crated the user can see it
        return questionService.addQuestion(questionRequestObject);
    }

    @PutMapping("editquestion/{questionId}")
    public Question addQuestion(@RequestBody QuestionUpdateRequest updateRequest, @PathVariable long questionId)
    {
        return questionService.editQuestion(updateRequest, questionId);
    }
    
}
