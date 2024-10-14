package com.task.taskmanagement.dto;

import com.task.taskmanagement.model.Task;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9@_]{8,}$")
    private String username;

    @NotBlank
    @Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&*!]).{8,}$",message="Password is not valid ")
    private String password;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9_]+@[A-Za-z]{6}+\\.[a-z]{2,4}$")
    private String email;

    @OneToMany(mappedBy = "user",cascade= CascadeType.ALL)
    private List<Task> tasks;
}
