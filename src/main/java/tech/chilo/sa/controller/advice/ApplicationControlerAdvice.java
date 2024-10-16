package tech.chilo.sa.controller.advice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import tech.chilo.sa.dto.ErrorEntity;

@ControllerAdvice
public class ApplicationControlerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public @ResponseBody     ErrorEntity handleException(EntityNotFoundException exception){
        return new ErrorEntity(null , exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({RuntimeException.class})
    public @ResponseBody     ErrorEntity handleRuntimeException(RuntimeException exception){
        return new ErrorEntity(null , exception.getMessage());
    }
}
