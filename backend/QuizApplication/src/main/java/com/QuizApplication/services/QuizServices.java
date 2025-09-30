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




    //this method generate questionList based on the user request
    public List<Question> getListOfQuestions(String category, String difficultyLevel)
    {
        //Here converting the enum values to string
        List<String> difficultyLevels = stream(difficulty.values()).map(Enum::toString).toList();

        List<Question> questionList = new ArrayList<>();

        //here checking if the list doesn't contains the given difficultyLevel from the user for the seek of simplicity I include all the levels
        if (difficultyLevel.isBlank() || !difficultyLevels.contains(difficultyLevel))
        {
            questionList = questionRepository.findAllByCategory(category);
        }
        //here if the difficulty level valid list of questions will be created base on CategoryAndDifficultyLevel
        else if (!difficultyLevel.isBlank() && !category.isBlank() && difficultyLevels.contains(difficultyLevel))
        {
            questionList = questionRepository.findAllByCategoryAndDifficultyLevel(category, difficulty.valueOf(difficultyLevel));
        }

        return questionList;
    }

}
