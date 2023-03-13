package com.todo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private int todoNo;
    private String todoName;
    private String todoContent;
    private String todoSuccess;

    public Todo(String todoName, String todoContent) {
        this.todoName = todoName;
        this.todoContent = todoContent;
    }
}
