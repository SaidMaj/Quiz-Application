package com.QuizApplication.services;

import com.QuizApplication.dto.QuizDto;
import com.QuizApplication.dto.QuizQuestionDto;
import com.QuizApplication.dto.UserAnswer;
import com.QuizApplication.entities.Question;
import com.QuizApplication.entities.Quiz;
import com.QuizApplication.entities.difficulty;
import com.QuizApplication.exceptions.BadRequestException;
import com.QuizApplication.exceptions.QuestionNotFoundException;
import com.QuizApplication.exceptions.ResourcesNotFoundException;
import com.QuizApplication.repository.QuestionRepository;
import com.QuizApplication.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.QuizApplication.Utilites.StringUtility.capitalizeWord;
import static java.util.Arrays.stream;

@Service
public class QuizServices {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private MappingServices mappingServices;

}
