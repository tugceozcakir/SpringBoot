package com.allianz.example.controller;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.service.CategoryService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController extends BaseController<CategoryEntity, CategoryDTO, CategoryRequestDTO, CategoryService> {

    @Autowired
    CategoryService categoryService;

    @Override
    protected CategoryService getService() {
        return categoryService;
    }
}

