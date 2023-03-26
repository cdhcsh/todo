package com.todo.entity.dto;

import com.todo.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoSaveRequestDTO implements TodoRequestDTO{
    @NotBlank
    @NotNull
    private String todoName;

    @NotBlank
    @NotNull
    private String todoContent;

    @Override
    public Todo toEntity(){
        return Todo.builder().todoName(todoName).todoContent(todoContent).build();
    }
}
