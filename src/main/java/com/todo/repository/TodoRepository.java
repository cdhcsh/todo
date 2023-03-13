package com.todo.repository;

import com.todo.entity.Todo;
import com.todo.entity.TodoSaveRequestDTO;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    public Optional<Todo> findById(int todo_no);

    public List<Todo> findAll();

    public Optional<Todo> save(TodoSaveRequestDTO todo);

    public Optional<Todo> update(TodoSaveRequestDTO todo);

    public boolean delete(int todo_no);
}
