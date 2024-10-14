package com.task.taskmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.taskmanagement.model.Category;
import com.task.taskmanagement.model.Task;
import com.task.taskmanagement.model.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskDto {


    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @Enumerated(EnumType.STRING)
    private Task.Priority priority;

    @Enumerated(EnumType.STRING)
    private Task.Status status;




}
