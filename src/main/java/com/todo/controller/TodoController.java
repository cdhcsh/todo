package com.todo.controller;

import com.todo.entity.TodoSaveRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/todo")
public class TodoController {

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
     * @param todo_no
     * @return
     */
    @GetMapping("{todo_no}")
    public String viewById(@PathVariable int todo_no){
        return "view " + todo_no;
    }

    /**
     * todo 생성
     * @param todo
     * @return
     */
    @PostMapping
    public HashMap<Integer,TodoSaveRequestDTO> insert(@RequestBody TodoSaveRequestDTO todo){
        HashMap<Integer,TodoSaveRequestDTO> list = new HashMap<>();
        list.put(1,todo);
        list.put(2,todo);
        list.put(3,todo);
        return list;
    }

    /**
     * todo 수정
     * @param todo_no
     * @return
     */
    @PatchMapping("{todo_no}")
    public String update(@PathVariable int todo_no){
        return "patch " + todo_no;
    }

    /**
     * todo 삭제
     * @param todo_no
     * @return
     */
    @DeleteMapping("{todo_no}")
    public String delete(@PathVariable int todo_no){
        return "delete " + todo_no;
    }


}
