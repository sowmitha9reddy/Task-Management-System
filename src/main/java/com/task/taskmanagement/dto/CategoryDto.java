package com.task.taskmanagement.dto;

import com.task.taskmanagement.model.Task;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDto {

       @NotEmpty
        @Pattern(regexp = "^[A-Z][a-z]{3,}$",message="Not Valid Name")
        private String name;

        @OneToMany(mappedBy = "category" ,cascade= CascadeType.ALL)
        private List<Task> tasks;


}
