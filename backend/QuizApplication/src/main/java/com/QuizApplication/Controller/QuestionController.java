package com.QuizApplication.Controller;

import com.QuizApplication.entities.Question;
import com.QuizApplication.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

}
