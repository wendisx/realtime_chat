## exception

该部分主要记录异常处理和抛出异常

> 异常常量类

主要作用： 解决异常抛出信息硬编码问题

命名规范：`constant/<service-name>ExceptionConstant.java`

示例：

```java
public class UserExceptionConstant {
    public static final String USERNAME_NOT_FOUND = "用户名不存在";
}
```

> 异常类

主要作用：自定义异常，方便全局异常处理捕获异常

命名规范：`exception/<service-name>Exception.java`

示例：

```java
public class UserException extends RuntimeException {
    public UserException(String message){
        super(message)
    }
}
```

> 异常处理

主要作用：核心为全局异常处理，捕获异常，统一错误响应格式

命名规范：`handler/<exception>Handler.java`

示例：

```java
public class GlobalExceptionHandler {
    public ResponseEntity<Response<Object>> handleException(Exception e) {
        // 特殊处理
        return ResponseEntity
                .status()
                .body(Response.error("服务器内部错误"));
     }
}
```