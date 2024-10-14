package com.task.taskmanagement.service;

import com.task.taskmanagement.dto.CategoryDto;
import com.task.taskmanagement.exception.CategoryNotFoundException;
import com.task.taskmanagement.model.Category;
import com.task.taskmanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryDaoService implements CategoryDao{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = new Category(categoryDto);

        return maptoDto(categoryRepository.save(category));
    }



    private CategoryDto maptoDto(Category category) {

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        return categoryDto;
    }
    @Override
    public CategoryDto getCategory(long id) {
        return maptoDto(categoryRepository.findById(id).orElseThrow(() ->new CategoryNotFoundException("Category Id not Found")));
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto,long id) {
         Category category = categoryRepository.findById(id).orElseThrow(() ->new CategoryNotFoundException("Category Id not Found"));

         category.setName(categoryDto.getName());
         return maptoDto(categoryRepository.save(category));
    }



    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(category -> maptoDto(category)).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(long id) {
           categoryRepository.deleteById(id);
    }
}
