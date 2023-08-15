package com.example.salesproject.controller;

import com.example.salesproject.database.entity.CategoryEntity;
import com.example.salesproject.database.repository.CategoryRepository;
import com.example.salesproject.mapper.CategoryMapper;
import com.example.salesproject.model.CategoryDTO;
import com.example.salesproject.model.requestDTO.CategoryRequestDTO;
import com.example.salesproject.service.CategoryService;
import com.example.salesproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController extends BaseController<
        CategoryEntity,
        CategoryDTO,
        CategoryRequestDTO,
        CategoryMapper,
        CategoryRepository,
        CategoryService> {

    @Autowired
    CategoryService categoryService;

    @Override
    protected CategoryService getService() {
        return categoryService;
    }
}
