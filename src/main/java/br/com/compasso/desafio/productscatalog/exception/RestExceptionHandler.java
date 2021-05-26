package br.com.compasso.desafio.productscatalog.exception;

import br.com.compasso.desafio.productscatalog.model.ErrorModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder errorsStringBuilder = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String fieldErrorMessage = fieldError.getField() + " : " + fieldError.getDefaultMessage();
            errorsStringBuilder.append(fieldErrorMessage);
            errorsStringBuilder.append(",");
        }
        ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST.value(), errorsStringBuilder.toString());
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgument(MethodArgumentTypeMismatchException e){
        ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
