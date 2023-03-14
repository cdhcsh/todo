package com.todo;

import com.todo.entity.Todo;
import com.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoJPATest {
    @Autowired
    TodoRepository todoRepository;
    @Test
    public void insertTest(){
        for (int i = 0; i < 5; i++) {
            Todo todo = Todo.builder().todoName("name " +i).todoContent("content " + i).build();
            System.out.println(todo);
            todoRepository.save(todo);
        }

    }
}
