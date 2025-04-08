## response

该部分主要记录响应结构以及相关方法

主要结构：

| 操作提示符 | 信息 | 数据 |
|:--------:|:----:|:----:|
|code|message|data|
|int|String|T|

tips: 这里的code不代表statusCode,仅代表操作是否成功,需要区分开来

示例响应：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {}
}
```

主要方法：

1) `success(T data)`

```java
User user = new User();
Response.success(user)
```

2) `error(String message)`

```java
Response.error("失败提示信息")
```