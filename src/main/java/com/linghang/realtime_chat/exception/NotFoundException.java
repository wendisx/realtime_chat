package com.linghang.realtime_chat.exception;

/**
 * 资源未找到异常
 */

 public class NotFoundException extends RuntimeException {
    // 构造方法
    public NotFoundException(String message){
        super(message);
    }
 }
