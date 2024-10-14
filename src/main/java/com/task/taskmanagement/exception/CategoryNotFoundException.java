package com.task.taskmanagement.exception;

public class CategoryNotFoundException  extends RuntimeException{
    public CategoryNotFoundException(String Message){
        super(Message);
    }
}
