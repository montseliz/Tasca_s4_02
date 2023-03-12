package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.exception;

import cat.itacademy.barcelonactiva.liz.montse.s04.t02.n03.model.dto.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(FruitNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Message> fruitNotFoundExceptionHandler(FruitNotFoundException exception, WebRequest request) {

        return new ResponseEntity<>(new Message(HttpStatus.NOT_FOUND.value(), new Date(), exception.getMessage(), request.getDescription(false)), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FruitValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Message> fruitValidationExceptionHandler(FruitValidationException exception, WebRequest request) {

        return new ResponseEntity<>(new Message(HttpStatus.BAD_REQUEST.value(), new Date(), exception.getMessage(), request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }

}
