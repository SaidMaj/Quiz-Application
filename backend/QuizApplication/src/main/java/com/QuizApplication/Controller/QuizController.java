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

}
