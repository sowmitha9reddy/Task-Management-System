package com.task.taskmanagement.exception;

public class UserNotFoundException extends RuntimeException{
   public UserNotFoundException(String message){
       super(message);
   }
}
