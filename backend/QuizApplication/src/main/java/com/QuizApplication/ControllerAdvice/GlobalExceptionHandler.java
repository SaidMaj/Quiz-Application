package com.QuizApplication.ControllerAdvice;

import com.QuizApplication.exceptions.QuestionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice

public class GlobalExceptionHandler
{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> returnFiledAndItErrors(MethodArgumentNotValidException ex)
    {
        Map<String, String> filedAndErrors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors())
        {
            filedAndErrors.put(error.getField(), error.getDefaultMessage());
        }

        return filedAndErrors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(QuestionNotFoundException.class)
    public String questionNotFoundException(QuestionNotFoundException questionNotFoundException)
    {
        return questionNotFoundException.getMessage();
    }
}
