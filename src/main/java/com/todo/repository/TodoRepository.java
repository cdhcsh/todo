package com.todo.repository;

import com.todo.entity.TodoSaveRequestDTO;
import com.todo.entity.TodoSelectResponseDTO;

import java.util.List;

public interface TodoRepository {
    public TodoSelectResponseDTO findById(int id);

    public List<TodoSelectResponseDTO> findAll();

    public TodoSelectResponseDTO save(TodoSaveRequestDTO todo);

    public TodoSelectResponseDTO update(TodoSaveRequestDTO todo);

    public boolean delete(int id);
}
