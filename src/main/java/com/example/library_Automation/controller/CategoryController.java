package com.example.library_Automation.controller;


import com.example.library_Automation.model.request.CategoryUpdateRequest;
import com.example.library_Automation.model.response.BaseResponse;
import com.example.library_Automation.model.response.CategoryResponse;
import com.example.library_Automation.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public List<CategoryResponse> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @PostMapping
    public BaseResponse saveCategory(){
        return null;
    }

    @PutMapping
    public BaseResponse updateCategory(@RequestBody @Valid CategoryUpdateRequest request){
        return null;
    }

    @DeleteMapping("/{categoryName}")
    public BaseResponse deleteCategory(@PathVariable("categoryName") String name){
        return null;
    }
}
