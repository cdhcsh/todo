package com.todo.entity;

import lombok.Data;

@Data
public class TodoUpdateRequestDTO {
    private int todo_no;
    private String todo_name;
    private String todo_content;
    private String todo_success;
}
