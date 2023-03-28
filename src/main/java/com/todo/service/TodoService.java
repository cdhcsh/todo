package com.todo.service;

import com.todo.entity.Todo;
import com.todo.entity.dto.TodoRequestDTO;
import com.todo.entity.dto.TodoSaveRequestDTO;
import com.todo.entity.dto.TodoResponseDTO;
import com.todo.entity.dto.TodoUpdateRequestDTO;
import com.todo.exception.TodoNotFoundException;
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
    public Optional<TodoResponseDTO> find(Integer id) throws TodoNotFoundException {
        Optional<Todo> entity = todoRepository.findById(id);
        if(entity.isEmpty()) throw new TodoNotFoundException();
        return entity.map(TodoResponseDTO::from);
    }
    public TodoResponseDTO save(TodoRequestDTO dto){
        return TodoResponseDTO.from(todoRepository.save(dto.toEntity()));
    }
    public TodoResponseDTO update(TodoRequestDTO dto) throws TodoNotFoundException {
        System.out.println(dto.toEntity());
        Optional<Todo> entity = todoRepository.findById(dto.toEntity().getTodoNo());
        if(entity.isEmpty()) throw new TodoNotFoundException();
        Todo todo = entity.get();
        todo.copy(dto.toEntity());
        return TodoResponseDTO.from(todoRepository.save(dto.toEntity()));
    }
    public void delete(Integer id) throws TodoNotFoundException {
        if(todoRepository.findById(id).isEmpty()) {
            throw new TodoNotFoundException();
        }
        todoRepository.deleteById(id);
    }
}
