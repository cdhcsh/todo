package com.todo.entity;

import lombok.Data;

@Data
public class TodoSelectResponseDTO {
    private int todo_no;
    private String todoName;
    private String todoContent;
    private String todoSuccess;
}
