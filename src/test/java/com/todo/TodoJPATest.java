package com.todo;

import com.todo.entity.Todo;
import com.todo.entity.TodoSelectResponseDTO;
import com.todo.repository.TodoRepository;
import com.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TodoJPATest {
    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TodoService todoService;


    @Test
    public void insertTest() {
        for (int i = 0; i < 5; i++) {
            Todo todo = Todo.builder().todoName("name " + i).todoContent("content " + i).build();
            System.out.println(todo);
            todoRepository.save(todo);
        }
    }

    @Test
    public void findAllTest() {
        List<TodoSelectResponseDTO> list = todoService.find();
        list.forEach(System.out::println);
        assertThat(list.size() == 5);
    }
    @Test
    public void findTest(){
        Optional<TodoSelectResponseDTO> t1 = todoService.find(1);
        Optional<TodoSelectResponseDTO> t2 = todoService.find(7);
        assertThat(t1.isPresent());
        assertThat(t2.isEmpty());
    }


}
