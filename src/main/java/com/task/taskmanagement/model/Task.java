package com.task.taskmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.taskmanagement.dto.TaskDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;

@Entity
@Table(name="task")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
    //: id, title, description, dueDate, status, priority, category,
    //user


    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnore
    private Category category;



    public enum Priority{

        Low,
       Medium,
       High
    }

    public enum Status{
        Pending,
        In_Progress,
        Completed
    }
    public Task(TaskDto taskDto) {
        this.title = taskDto.getTitle();
        this.description = taskDto.getDescription();
        this.priority = taskDto.getPriority();
        this.status = taskDto.getStatus();

    }


}
