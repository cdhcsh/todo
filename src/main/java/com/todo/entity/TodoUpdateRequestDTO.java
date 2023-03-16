package com.todo.entity;

import lombok.Data;

@Data
public class TodoUpdateRequestDTO {
    private int todoNo;
    private String todoName;
    private String todoContent;
    private String todoSuccess;
    public Todo toEntity(){
        return new Todo(todoNo,todoName,todoContent,todoSuccess);
    }
}
