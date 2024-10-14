package com.task.taskmanagement.model;

import com.task.taskmanagement.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="user")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    //id, username, password, email, tasks

    @Id
    @GeneratedValue
    private long userId;
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user",cascade= CascadeType.ALL)
    private List<Task> tasks;

    public User(UserDto userDto) {
        this.username=userDto.getUsername();
        this.password=userDto.getPassword();
        this.email=userDto.getEmail();
    }
}
