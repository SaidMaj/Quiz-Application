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


    //Method used to create quiz
    public QuizDto createQuiz(String category, int numberOfQuestions, String difficultyLevel, String quizTitle)
    {
        //Based on the data entered by user list of question will be generated
        List<Question> questionList = addQuestions(category, numberOfQuestions, difficultyLevel);
        //Creating a new object of quiz and add the necessary data
        Quiz quiz = createQuizObject(quizTitle, numberOfQuestions, category,difficultyLevel, questionList);
        //saving the quiz to the database
        quizRepository.save(quiz);

        QuizDto quizDto = mappingServices.convertingQuizToDto(quiz);

        return quizDto;
    }




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

    //this method validateQuestionList and ensures it according to the user requirements
    public void validateQuestionList(String category, int numberOfQuestions, String difficultyLevel, List<Question> questionList)
    {
        if (questionList.isEmpty())
        {
            throw new ResourcesNotFoundException("Questions with given, Category : " + category + " , difficultyLevel : " + difficultyLevel + " Not Found");
            /* here where checking if the given numberQuestions is greater than the list size */
        }else if (numberOfQuestions > questionList.size())
        {
            throw new BadRequestException("Bad Request : The given number of questions is larger than the number of questions in the database");
        }

    }

    public Quiz createQuizObject(String quizTitle , int numberOfQuestions, String category, String  difficultyLevel, List<Question> questionList)
    {
        Quiz quiz = new Quiz();

        quiz.setQuizTitle(quizTitle);
        quiz.setNumberOfQuestions(numberOfQuestions);
        quiz.setCategory(category);
        quiz.setQuestions(questionList);
        quiz.setDifficultyLevel(difficultyLevel);

        return quiz;
    }

    public List<Question> addQuestions(String category, int numberOfQuestions, String difficultyLevel)  {

        // here I am capitalized difficultyLevel to ensure when it converted to enum it will equal to the number that I have added
        difficultyLevel=  capitalizeWord(difficultyLevel);
        category =  capitalizeWord(category);

        //here I will get all questions related to specific category or a difficultyLevel || in case difficultyLevel doesn't exist or misspelled it will generate with all the levels
        List<Question> questionList = getListOfQuestions(category, difficultyLevel);
        //declaring a list to store the questions
        List<Question> quizQuestionList = new ArrayList<>();
        int questionListSize = questionList.size();
        //Initialization of random object to get random numbers
        Random random = new Random();

        //I am validating the questionList to ensure the quiz along with user requirements
        validateQuestionList(category, numberOfQuestions, difficultyLevel, questionList);

        //here I am iterating through the questionlist and map each question to QuizQuestionDto to show only the necessary data
        for (int i = 0 ; i < numberOfQuestions; i++)
        {
            //here geting a random number from 1 - questionListSize
            long RandomNumber = random.nextLong(0,questionListSize);
            Question question = questionList.get((int)RandomNumber);
            quizQuestionList.add(question);
        }


        return  quizQuestionList;
    }



}
