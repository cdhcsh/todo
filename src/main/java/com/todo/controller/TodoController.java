package com.todo.controller;

import com.todo.entity.ResponseObject;
import com.todo.entity.dto.TodoSaveRequestDTO;
import com.todo.entity.dto.TodoUpdateRequestDTO;
import com.todo.exception.TodoNoNotMatchedException;
import com.todo.exception.TodoNotFoundException;
import com.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import static com.todo.entity.ResponseObject.from;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;


    /**
     * 모든 todo 조회
     *
     * @return
     */
    @GetMapping
    public ResponseObject viewAll() {
        return from(todoService.find());
    }

    /**
     * {todo_no}인 todo 조회
     *
     * @param todoNo
     * @return
     */
    @GetMapping("{todoNo}")
    public ResponseObject viewById(@PathVariable int todoNo) throws TodoNotFoundException {
        return from(todoService.find(todoNo));
    }

    /**
     * todo 생성
     *
     * @param todo
     * @return
     */
    @PostMapping
    public ResponseObject insert(@RequestBody @Validated TodoSaveRequestDTO todo) {
        return from(todoService.save(todo));
    }

    /**
     * todo 수정
     * @param todoNo
     * @param todo
     * @return
     */
    @PatchMapping("{todoNo}")
    public ResponseObject update(@PathVariable int todoNo, @RequestBody @Validated TodoUpdateRequestDTO todo) throws TodoNoNotMatchedException, TodoNotFoundException {
        if(todoNo != todo.getTodoNo()){
            throw new TodoNoNotMatchedException();
        }
        return from(todoService.update(todo));
    }

    /**
     * todo 삭제
     *
     * @param todoNo
     * @return
     */
    @DeleteMapping("{todoNo}")
    public ResponseObject delete(@PathVariable int todoNo) throws TodoNotFoundException {
        todoService.delete(todoNo);
        return viewAll();
    }


}
