package com.QuizApplication.Controller;

import com.QuizApplication.dto.QuizDto;
import com.QuizApplication.dto.QuizQuestionDto;
import com.QuizApplication.dto.UserAnswer;
import com.QuizApplication.entities.Question;
import com.QuizApplication.entities.Quiz;
import com.QuizApplication.services.QuizServices;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@Validated
public class QuizController {
    @Autowired
    private QuizServices quizServices;

    @PostMapping("/create")
    public ResponseEntity<QuizDto> generateQuiz(@NotBlank(message = "category must not be empty") @RequestParam() String category,
                                                @Positive(message = "Number of questions must be greater than 0") @RequestParam(name = "noOfQuestions"  ) int numberOfQuestions,
                                                @RequestParam(required = false, defaultValue = "All") String difficultyLevel,
                                                @NotBlank(message = "QuizTitle must not be empty") @RequestParam String quizTitle)
    {
        return new ResponseEntity<>(quizServices.createQuiz(category, numberOfQuestions, difficultyLevel, quizTitle), HttpStatus.CREATED);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<List<QuizQuestionDto>> getQuiz(@PathVariable int quizId)
    {
        return new ResponseEntity<>(quizServices.getQuiz(quizId), HttpStatus.OK);
    }

    @PutMapping("/update/{quizId}")
    public ResponseEntity<QuizDto> updateQuiz(@PathVariable int quizId,
                                              @NotBlank(message = "category must not be empty") @RequestParam() String category,
                                              @Positive(message = "Number of questions must be greater than 0") @RequestParam(name = "noOfQuestions"  ) int numberOfQuestions,
                                              @RequestParam(required = false, defaultValue = "All") String difficultyLevel,
                                              @NotBlank(message = "QuizTitle must not be empty") @RequestParam String quizTitle)
    {
        return new ResponseEntity<>(quizServices.updateQuiz(quizId, category, numberOfQuestions, difficultyLevel, quizTitle), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{quizId}")
    public ResponseEntity<String> deleteQuiz(@PathVariable int quizId)
    {
        return new ResponseEntity<>(quizServices.deleteQuiz(quizId), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/submit/{quizId}")
    public ResponseEntity<String> submitAnswer(@PathVariable int quizId, @RequestBody List<UserAnswer> userAnswerList)
    {
        return new ResponseEntity<>(quizServices.submitAnswer(quizId, userAnswerList), HttpStatus.OK);
    }

}
