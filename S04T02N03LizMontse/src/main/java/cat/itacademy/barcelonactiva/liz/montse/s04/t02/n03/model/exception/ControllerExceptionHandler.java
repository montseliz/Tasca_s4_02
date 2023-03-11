package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(FruitNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage fruitNotFoundExceptionHandler(FruitNotFoundException exception, WebRequest request) {

        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), exception.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(FruitValidationException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage fruitValidationExceptionHandler(FruitValidationException exception, WebRequest request) {

        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), exception.getMessage(), request.getDescription(false));
    }

}
