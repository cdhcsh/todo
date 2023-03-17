package com.todo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.valueextraction.ExtractedValue;

@Data
public class TodoUpdateRequestDTO {
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
    public Todo toEntity(){
        return new Todo(todoNo,todoName,todoContent,todoSuccess);
    }
}
