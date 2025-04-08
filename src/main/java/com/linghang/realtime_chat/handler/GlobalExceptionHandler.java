package com.linghang.realtime_chat.handler;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.linghang.realtime_chat.common.Response;

/**
 * 全局异常处理
 */
@RestControllerAdvice
 public class GlobalExceptionHandler {
    
    // 参数校验异常 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Object>> handleInvalidArgsException(MethodArgumentNotValidException e) {
        // 找到错误信息
        String message = Optional.ofNullable(e.getBindingResult().getFieldError())
                             .map(FieldError::getDefaultMessage)
                             .orElse("未知参数错误");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Response.error(message));
    }

    // 资源未找到异常 404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response<Object>> handleResourceNotFoundException(NotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Response.error(e.getMessage()));
    }

    // ...自定义异常 200
    

    // 服务器异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Object>> handleException(Exception e) {
        // 内部打印异常
        e.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response.error("服务器内部错误"));
    }
 }