package com.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoSelectResponseDTO {
    private int todo_no;
    private String todoName;
    private String todoContent;
    private String todoSuccess;

    public static TodoSelectResponseDTO from(Todo todo) {
        return new TodoSelectResponseDTO(todo.getTodoNo(), todo.getTodoName(), todo.getTodoContent(), todo.getTodoSuccess());
    }
}
