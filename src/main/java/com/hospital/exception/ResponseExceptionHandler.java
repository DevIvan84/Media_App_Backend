package com.hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handlerModelNotFoundException(ModelNotFoundException ex, WebRequest request){
        CustomErrorResponse err = new CustomErrorResponse(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }


    /*@ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorRecord> handlerModelNotFoundException(ModelNotFoundException ex, WebRequest request){
        CustomErrorRecord err = new CustomErrorRecord(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }*/

    //Desde Spring boot 3
   /* @ExceptionHandler(ModelNotFoundException.class)
    public ProblemDetail handlerModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        pd.setTitle("Model Not Found Exception");
        pd.setType(URI.create(request.getDescription(false)));
        pd.setProperty("extra1", "extra-value");
        pd.setProperty("extra2", 33);
        return pd;
    }*/

        //Desde Spring boot 3
        /*@ExceptionHandler(ModelNotFoundException.class)
        public ErrorResponse handlerModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
            return ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, ex.getMessage())
                    .title("Model Not Found Exception")
                    .type(URI.create(request.getDescription(false)))
                    .property("extra1", "extra-value")
                    .property("extra2", 33)
                    .build();
        }*/



}
