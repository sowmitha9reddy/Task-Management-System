package com.task.taskmanagement.service;

import com.task.taskmanagement.dto.TaskDto;
import com.task.taskmanagement.model.Task;

import java.util.List;

public interface TaskDao {

    public TaskDto addTask(TaskDto taskDto);
    public TaskDto updateTaskDetails(long id,TaskDto taskDto);
    public void deleteTask(Task task);
    public TaskDto getTaskById(long id);
    public List<TaskDto> getAllTasks();
}
