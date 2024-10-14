package com.task.taskmanagement.controller;


import com.task.taskmanagement.dto.CategoryDto;
import com.task.taskmanagement.dto.TaskDto;
import com.task.taskmanagement.service.CategoryDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Category")
public class CategoryContoller {

    @Autowired
    private CategoryDaoService categoryDaoService;

    @PostMapping("/addcc")
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto) {
        return  categoryDaoService.addCategory(categoryDto);
    }

    @PostMapping("/{id}")
    public CategoryDto updateCategory(@PathVariable long id, @RequestBody CategoryDto categoryDto){
        return categoryDaoService.updateCategory(categoryDto,id);
    }

    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable long id){
        return categoryDaoService.getCategory(id);
    }

    @GetMapping("/")
    public List<CategoryDto> getCategory(){
        return categoryDaoService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id){
         categoryDaoService.deleteCategory(id);

    }

}
