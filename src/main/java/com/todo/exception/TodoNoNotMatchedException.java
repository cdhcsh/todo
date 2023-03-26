package com.todo.exception;

public class TodoNoNotMatchedException extends Exception{
    final static String ERROR_CODE = "NotMatch";
    final static String ERROR_FIELD = "TodoNo";
    public String getErrorCode(){
        return ERROR_CODE;
    }

    public String getName() {
        return ERROR_FIELD;
    }
}
