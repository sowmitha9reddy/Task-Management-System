package com.task.taskmanagement.controller;

import com.task.taskmanagement.dto.UserDto;
import com.task.taskmanagement.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usercontroller")  // Corrected the mapping here
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @PostMapping("/addph")
    public UserDto addUser(@RequestBody UserDto userDto) {  // Added @RequestBody
        return userDaoService.registerUser(userDto);
    }

    @PostMapping("/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable long id) {  // Added @RequestBody
        return userDaoService.updateUser(userDto, id);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable long id) {
        return userDaoService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userDaoService.deleteUserById(id);
    }
}
