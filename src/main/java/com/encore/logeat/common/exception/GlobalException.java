package com.encore.logeat.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFoundExceptionHandle(EntityNotFoundException e) {

        /* body -> Response 엔티티적용해서 반환 */
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(HttpStatus.NOT_FOUND.toString() + " : " + e.toString());
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentExceptionHandle(IllegalArgumentException e) {
ㅁㄴㅇ
        /* body -> Response 엔티티적용해서 반환 */
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(HttpStatus.BAD_REQUEST.toString() + " : " + e.toString());
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandle(RuntimeException e) {

        /* body -> Response 엔티티적용해서 반환 */
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(HttpStatus.INTERNAL_SERVER_ERROR.toString() + " : " + e.toString());
    }

}
