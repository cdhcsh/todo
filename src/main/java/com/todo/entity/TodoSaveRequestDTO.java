package com.todo.entity;

import lombok.Data;

@Data
public class TodoSaveRequestDTO {
    private String todoName;
    private String todoContent;
}
