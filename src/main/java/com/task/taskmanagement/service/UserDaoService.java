package com.task.taskmanagement.service;

import com.task.taskmanagement.dto.UserDto;
import com.task.taskmanagement.exception.UserNotFoundException;
import com.task.taskmanagement.model.Task;
import com.task.taskmanagement.model.User;
import com.task.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoService implements UserDao{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto registerUser(UserDto userDto) {
        User user=new User(userDto);
        return maptoDto(userRepository.save(user));
    }

    private UserDto maptoDto(User user) {
        UserDto userDto=new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
    @Override
    public UserDto findUserById(long id) {
           User user=userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Id not Found"));
           return maptoDto(user);
    }
    @Override
    public UserDto updateUser(UserDto userDto,long id) {
        User user=userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id Not  found"));

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return maptoDto(userRepository.save(user));

    }



    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public UserDto findUserByEmail(String email) {
        User user=userRepository.findByEmail(email);
        return maptoDto(user);

    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }
}
