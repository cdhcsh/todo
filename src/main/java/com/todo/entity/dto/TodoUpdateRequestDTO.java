package com.todo.entity.dto;

import com.todo.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoUpdateRequestDTO implements TodoRequestDTO{
    @NotNull
    private int todoNo;

    @NotNull
    @NotBlank
    private String todoName;

    @NotNull
    @NotBlank
    private String todoContent;

    @NotNull
    @Pattern(regexp = "^[NY]$")
    private String todoSuccess;

    @Override
    public Todo toEntity(){
        return new Todo(todoNo,todoName,todoContent,todoSuccess);
    }
}
