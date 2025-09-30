package com.QuizApplication.ControllerAdvice;

import com.QuizApplication.exceptions.BadRequestException;
import com.QuizApplication.exceptions.QuestionAlreadyExistsException;
import com.QuizApplication.exceptions.QuestionNotFoundException;
import com.QuizApplication.exceptions.ResourcesNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.lang.reflect.Field;
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

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(QuestionAlreadyExistsException.class)
    public String questionAlreadyExistsException(QuestionAlreadyExistsException questionAlreadyExistsException)
    {
        return questionAlreadyExistsException.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourcesNotFoundException.class)
    public  String resourcesNotFoundException(ResourcesNotFoundException resourcesNotFoundException)
    {
        return resourcesNotFoundException.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handlingConstraintViolationException(ConstraintViolationException constraintViolationException)
    {
        Map<String, String> map = new HashMap<>();

        for(ConstraintViolation<?> errors : constraintViolationException.getConstraintViolations())
        {
            map.put(String.valueOf(errors.getPropertyPath()), errors.getMessage());
        }

        return map;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public String badRequestException(BadRequestException badRequestException)
    {
        return badRequestException.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException)
    {
        String fieldName = methodArgumentTypeMismatchException.getName();
        String Causes = methodArgumentTypeMismatchException.getCause().getMessage();
        String exceptedDatatype = methodArgumentTypeMismatchException.getRequiredType().toString();


        String error = String.format("%s : excepted the following DataType \"%s\" but got this : %s", fieldName, exceptedDatatype, Causes);


        return error ;
    }

}
