package com.atguigu.springcloud.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CommentResult<T> {
    private Integer code;
    private String message;
    private T data;
}
