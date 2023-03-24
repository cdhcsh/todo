package com.todo.service;

import com.todo.entity.Todo;
import com.todo.entity.TodoSaveRequestDTO;
import com.todo.entity.TodoResponseDTO;
import com.todo.entity.TodoUpdateRequestDTO;
import com.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<TodoResponseDTO> find() {
        return todoRepository.findAll().stream()
                .map(TodoResponseDTO::from)
                .collect(Collectors.toList());
    }
    public Optional<TodoResponseDTO> find(Integer id){
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.map(TodoResponseDTO::from);
    }
    public TodoResponseDTO save(TodoSaveRequestDTO todo){
        return TodoResponseDTO.from(todoRepository.save(todo.toEntity()));
    }
    public TodoResponseDTO update(TodoUpdateRequestDTO todo){
        return TodoResponseDTO.from(todoRepository.save(todo.toEntity()));
    }
    public void delete(Integer id){
        todoRepository.deleteById(id);
    }
}
