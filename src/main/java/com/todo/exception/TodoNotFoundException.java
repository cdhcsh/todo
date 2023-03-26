package com.todo.exception;

public class TodoNotFoundException extends Exception{
    final static String ERROR_CODE = "NotFound";
    final static String ERROR_FIELD = "TodoNo";
    public String getErrorCode(){
        return ERROR_CODE;
    }

    public String getName() {
        return ERROR_FIELD;
    }
}
