package com.todo.entity.dto;

import com.todo.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class TodoResponseDTO {
    private int todo_no;
    private String todoName;
    private String todoContent;
    private String todoSuccess;

    public static TodoResponseDTO from(Todo todo) {
        return new TodoResponseDTO(todo.getTodoNo(), todo.getTodoName(), todo.getTodoContent(), todo.getTodoSuccess());
    }
}
