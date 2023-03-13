package com.todo.service;

import com.todo.entity.TodoSelectResponseDTO;
import com.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoSelectResponseDTO getTodo(int id){

    }
}
