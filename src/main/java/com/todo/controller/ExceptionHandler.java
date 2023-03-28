package com.todo.controller;

import com.todo.entity.ResponseObject;
import com.todo.exception.TodoNoNotMatchedException;
import com.todo.exception.TodoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler {
    private final MessageSource messageSource;

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler({MethodArgumentNotValidException.class})
    public Object validException(MethodArgumentNotValidException ex) {
        ResponseObject obj = ResponseObject.from();
        ex.getBindingResult().getFieldErrors().forEach(i -> obj.error(toMessage(i.getCode(), i.getField())));
        return obj;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseObject typeMismatchException(MethodArgumentTypeMismatchException ex) {
        return ResponseObject.from().error(toMessage(ex.getErrorCode(), ex.getName()));
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler({TodoNoNotMatchedException.class})
    public ResponseObject todoNoNotMachException(TodoNoNotMatchedException ex) {
        return ResponseObject.from().error(toMessage(ex.getErrorCode(), ex.getName()));
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler({TodoNotFoundException.class})
    public ResponseObject todoNoNotMachException(TodoNotFoundException ex) {
        return ResponseObject.from().error(toMessage(ex.getErrorCode(), ex.getName()));
    }

    public String toMessage(String type, String name) {
        return messageSource.getMessage(type + "." + name, new Object[]{}, Locale.KOREA);
    }
}
