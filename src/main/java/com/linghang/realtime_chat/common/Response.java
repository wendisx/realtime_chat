package com.linghang.realtime_chat.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 统一响应格式
 */

@Data
@AllArgsConstructor
public class Response<T> {
    // 响应状态 0:成功 1:失败
    private int code;
    // 响应信息
    private String message;
    // 响应数据
    private T data;
    // 成功响应 -- 返回数据
    public static <T> Response<T> success(T data) {
        return new Response<>(0,"操作成功",data);
    }
    // 失败响应 -- 返回错误信息
    public static <T> Response<T> error(String message) {
        return new Response<>(1,message,null);
    }
}