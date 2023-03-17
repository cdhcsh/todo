package com.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoSaveRequestDTO {
    @NotBlank
    @NotNull
    private String todoName;

    @NotBlank
    @NotNull
    private String todoContent;
    public Todo toEntity(){
        return Todo.builder().todoName(todoName).todoContent(todoContent).build();
    }
}
