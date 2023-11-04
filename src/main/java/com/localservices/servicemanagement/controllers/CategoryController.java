package com.localservices.servicemanagement.controllers;

import com.localservices.servicemanagement.dtos.ServiceResponseDto;
import com.localservices.servicemanagement.exceptions.NotFoundException;
import com.localservices.servicemanagement.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(
            CategoryService categoryService
    ) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryName}")
    public List<ServiceResponseDto> getServicesByCategoryName(@PathVariable String categoryName) {
        List<ServiceResponseDto> responseDtos = categoryService.getServicesByCategoryName(categoryName);
        return responseDtos;
    }
}
