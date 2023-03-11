package com.todo.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Todo {
    private final int todo_no;
    private final String todo_name;
    private final String todo_content;
    private final String todo_success;
}
