package com.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoSaveRequestDTO {
    private String todoName;
    private String todoContent;
    public Todo toEntity(){
        return new Todo(todoName,todoContent);
    }
}
