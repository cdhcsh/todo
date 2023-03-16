package com.todo.service;

import com.todo.entity.Todo;
import com.todo.entity.TodoSaveRequestDTO;
import com.todo.entity.TodoSelectResponseDTO;
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

    public List<TodoSelectResponseDTO> find() {
        return todoRepository.findAll().stream()
                .map(TodoSelectResponseDTO::from)
                .collect(Collectors.toList());
    }
    public Optional<TodoSelectResponseDTO> find(Integer id){
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isEmpty()) return Optional.empty();
        else return Optional.of(TodoSelectResponseDTO.from(todo.get()));
    }
    public TodoSelectResponseDTO save(TodoSaveRequestDTO todo){
        return TodoSelectResponseDTO.from(todoRepository.save(todo.toEntity()));
    }
    public TodoSelectResponseDTO update(TodoUpdateRequestDTO todo){
        return TodoSelectResponseDTO.from(todoRepository.save(todo.toEntity()));
    }
    public void delete(Integer id){
        todoRepository.deleteById(id);
    }
}
