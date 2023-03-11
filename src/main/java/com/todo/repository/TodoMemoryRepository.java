package com.todo.repository;

import com.todo.entity.TodoSaveRequestDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TodoMemoryRepository implements TodoRepository{
    private HashMap<Integer, Todo> store = new HashMap<>();

    @Override
    public Optional<Todo> findById(int todo_no) {
        if(store.containsKey(todo_no))
            return Optional.of(store.get(todo_no));
        else
            return Optional.empty();
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Todo> save(TodoSaveRequestDTO todo) {
        return null;
    }

    @Override
    public Optional<Todo> update(TodoSaveRequestDTO todo) {
        return null;
    }

    @Override
    public boolean delete(int todo_no) {
        return false;
    }
    @PostConstruct
    public void init(){
        store.put(1,new Todo(1,"test todo 1","test content 1","N"));
        store.put(2,new Todo(2,"test todo 2","test content 2","Y"));
    }
}
