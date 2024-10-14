package com.task.taskmanagement.model;

import com.task.taskmanagement.dto.CategoryDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="category")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    //Fields: id, name, tasks

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "category" ,cascade= CascadeType.ALL)
    private List<Task> tasks;

    public Category(CategoryDto categoryDto) {
        this.name=categoryDto.getName();
        this.tasks=categoryDto.getTasks();

    }
}
