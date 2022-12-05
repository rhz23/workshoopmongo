package com.rzaninelli.workshoopmongo.resources.exception;

import com.rzaninelli.workshoopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExcpetionHandler {

    @ExceptionHandler
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(err);
    }
}
