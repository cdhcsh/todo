package com.todo.controller;

import com.todo.entity.TodoSaveRequestDTO;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private MessageSource messageSource;


    /**
     * 모든 todo 조회
     * @return
     */
    @GetMapping
    public String viewAll(){
        return "viewAll";
    }

    /**
     * {todo_no}인 todo 조회
     * @param todoNo
     * @return
     */
    @GetMapping("{todoNo}")
    public String viewById(@PathVariable @Validated int todoNo){
        return "view " + todoNo;
    }

    /**
     * todo 생성
     * @param todo
     * @return
     */
    @PostMapping
    public HashMap<Integer,TodoSaveRequestDTO> insert(@RequestBody @Validated TodoSaveRequestDTO todo){
        HashMap<Integer,TodoSaveRequestDTO> list = new HashMap<>();
        list.put(1,todo);
        list.put(2,todo);
        list.put(3,todo);
        return list;
    }

    /**
     * todo 수정
     * @param todoNo
     * @return
     */
    @PatchMapping("{todoNo}")
    public String update(@PathVariable @Validated int todoNo){
        return "patch " + todoNo;
    }

    /**
     * todo 삭제
     * @param todoNo
     * @return
     */
    @DeleteMapping("{todoNo}")
    public String delete(@PathVariable int todoNo){
        return "delete " + todoNo;
    }


}
