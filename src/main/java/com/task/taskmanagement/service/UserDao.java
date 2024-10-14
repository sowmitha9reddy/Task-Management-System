package com.task.taskmanagement.service;

import com.task.taskmanagement.dto.UserDto;
import com.task.taskmanagement.model.Task;
import com.task.taskmanagement.model.User;

import java.util.List;

public interface UserDao {

//    Register a new User.
//○ Login
//○ Update User details.
//○ Delete a User.
//○ Retrieve a User’s tasks

    public UserDto registerUser(UserDto userDto);
    public UserDto updateUser(UserDto userDto,long id);
    public UserDto findUserById(long id);
    public void deleteUserById(long id);
    public UserDto findUserByEmail(String email);
    public User findUserByUsername(String username);



}
