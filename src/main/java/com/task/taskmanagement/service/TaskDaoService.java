package com.task.taskmanagement.service;

import com.task.taskmanagement.dto.TaskDto;
import com.task.taskmanagement.exception.CategoryNotFoundException;
import com.task.taskmanagement.exception.TaskNotFoundException;
import com.task.taskmanagement.exception.UserNotFoundException;
import com.task.taskmanagement.model.Category;
import com.task.taskmanagement.model.Task;
import com.task.taskmanagement.model.User;
import com.task.taskmanagement.repository.CategoryRepository;
import com.task.taskmanagement.repository.TaskRepository;
import com.task.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskDaoService implements TaskDao{

    @Autowired
   private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public TaskDto addTask(TaskDto taskDto) {
        Task task=new Task(taskDto);
        return mapToDto(taskRepository.save(task));

    }

    private TaskDto mapToDto(Task task) {
        TaskDto taskDto=new TaskDto();
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        taskDto.setPriority(task.getPriority());

        return taskDto;
    }


    @Override
    public TaskDto getTaskById(long id) {
        return mapToDto(taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task Id Not Found")));
    }

    @Override
    public TaskDto updateTaskDetails(long id, TaskDto taskDto) {
        Task task=taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task Id Not Found"));

        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setPriority(taskDto.getPriority());
        return mapToDto(taskRepository.save(task));

    }

    @Override
    public void deleteTask(Task task) {
             taskRepository.delete(task);
    }


    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(task -> mapToDto(task))
                .collect(Collectors.toList());
    }



    public void  linkTaskToUser(Long taskId,Long userId) {

       Task task =taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task Id Not found"));
        User user=userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user ID Not found"));

        task.setUser(user);
        taskRepository.save(task);

        System.out.println("Task Added to user Successfully");



    }
    public void  linkTaskToCategory(Long taskId, Long categoryId) {


        Task task =taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task Id Not found"));
        Category category=categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category Id Not Found"));

        task.setCategory(category);
        taskRepository.save(task);

        System.out.println("Task added to the Category Successfully");
    }


    public TaskDto updateStatus(Long taskId, Task.Status status){
        Task task=taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task Id Not Found Exception"));
        task.setStatus(status);
        return mapToDto(taskRepository.save(task));

    }

    public List<TaskDto> filterByStatus(Task.Status status){
        return taskRepository.findByStatus(status).stream()
                .map(task -> mapToDto(task))
                .collect(Collectors.toList());
    }

    public List<TaskDto> filterByPriority(Task.Priority priority){
        return taskRepository.findByPriority(priority).stream()
                .map(task -> mapToDto(task))
                .collect(Collectors.toList());
    }

    public List<TaskDto> filterByCategory(long categoryId){
        return taskRepository.findByCategoryId(categoryId).stream()
                .map(task -> mapToDto(task))
                .collect(Collectors.toList());
    }



}
