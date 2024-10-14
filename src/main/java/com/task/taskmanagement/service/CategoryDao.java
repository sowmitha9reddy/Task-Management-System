package com.task.taskmanagement.service;

import com.task.taskmanagement.dto.CategoryDto;

import java.util.List;


public interface CategoryDao {
//Create a new Category (e.g., "Work", "Personal").
//○ Update Category details (e.g., rename a category).
//○ Delete a Category.
//○ Retrieve all Categories or a specific Category by ID.
//○ Assign multiple Tasks to a Category.

    public CategoryDto addCategory(CategoryDto categoryDto);
    public CategoryDto updateCategory(CategoryDto categoryDto,long id);
    public CategoryDto getCategory(long id);
    public List<CategoryDto> getAllCategories();
    public void deleteCategory(long id);




}
