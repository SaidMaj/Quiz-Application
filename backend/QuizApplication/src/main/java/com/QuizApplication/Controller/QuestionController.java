package com.QuizApplication.Controller;

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
    QuestionService questionService;

    @GetMapping("getQuestions")
    public List<Question> questions()
    {
        return questionService.getQuestions();
    }
}
