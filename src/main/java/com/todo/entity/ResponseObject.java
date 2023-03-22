package com.todo.entity;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ResponseObject {
    public final Object result;
    public final List<String> exception_messages = new ArrayList<>();
    public ResponseObject error(String exception_message){
        exception_messages.add(exception_message);
        return this;
    }
    public static ResponseObject from(Object result){
        return new ResponseObject(result);
    }
    public static ResponseObject from(){
        return new ResponseObject(null);
    }
}
