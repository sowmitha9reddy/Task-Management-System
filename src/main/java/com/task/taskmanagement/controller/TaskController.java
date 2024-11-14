package com.task.taskmanagement.controller;

import com.task.taskmanagement.dto.CategoryDto;
import com.task.taskmanagement.dto.TaskDto;
import com.task.taskmanagement.exception.TaskNotFoundException;
import com.task.taskmanagement.model.Task;
import com.task.taskmanagement.service.TaskDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/TestController")
public class TaskController {


    @Autowired
    private TaskDaoService taskDaoService;


  @GetMapping("/home/Directory")
    public String home(){
        return "Welcome to task Management";
    }
    
    @PostMapping("/addTask")
    public TaskDto addTask(@RequestBody TaskDto taskDto) {
          return taskDaoService.addTask(taskDto);
    }


    @PostMapping("/{id}")
    public TaskDto updateTask(@PathVariable long id, @RequestBody TaskDto taskDto){
        return taskDaoService.updateTaskDetails(id,taskDto);
    }

   @GetMapping("/getTask/{id}")
    public TaskDto getTask(@PathVariable long id){
        return taskDaoService.getTaskById(id);
    }
    @GetMapping("/")
    public List<TaskDto> getCategory(){
        return  taskDaoService.getAllTasks();
    }

    @PostMapping("/linktaskToUser/{taskId}/{userId}")
    public void  linkTaskToUser(@PathVariable Long taskId,@PathVariable Long userId) {
        taskDaoService.linkTaskToUser(taskId,userId);


    }

    @PostMapping("/linkTaskToCategory/{taskId}/{categoryId}")
    public void  linkPolicyToAgent(@PathVariable Long taskId,@PathVariable Long categoryId) {
       taskDaoService.linkTaskToCategory(taskId,categoryId);
    }


    @PostMapping("/{taskId}/{status}")
    public TaskDto updateStatus(@PathVariable Long taskId,@PathVariable Task.Status status){
       return taskDaoService.updateStatus(taskId,status);

    }

    @GetMapping("/{status}")
    public List<TaskDto> filterByStatus(@PathVariable Task.Status status) {
        return taskDaoService.filterByStatus(status);
    }


    @GetMapping("/{priority}")
    public List<TaskDto> filterByPriority(@PathVariable Task.Priority priority){
        return taskDaoService.filterByPriority(priority);
    }

    @GetMapping("/{categoryId}")
    public List<TaskDto> filterByCategory(@PathVariable long categoryId){
        return taskDaoService.filterByCategory(categoryId);
    }





}
