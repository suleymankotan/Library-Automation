package com.example.library_Automation.service;

import com.example.library_Automation.entity.CategoryEntity;
import com.example.library_Automation.exception.ErrorCode;
import com.example.library_Automation.exception.LibraryServiceException;
import com.example.library_Automation.model.response.BaseResponse;
import com.example.library_Automation.model.response.CategoryResponse;
import com.example.library_Automation.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryEntity saveBookCategory(String categoryName){
        CategoryEntity categoryEntity= getByCategoryName(categoryName);
        if (categoryEntity!= null)
            return categoryEntity;
        return categoryRepository.save(CategoryEntity.builder().name(categoryName).build());
    }

    public BaseResponse saveCategory(String categoryName){
        CategoryEntity categoryEntity= getByCategoryName(categoryName);
        if (categoryEntity!= null)
            throw new LibraryServiceException(ErrorCode.GENERAL_EXCEPTION);
        categoryRepository.save(CategoryEntity.builder().name(categoryName).build());
        return BaseResponse.success();
    }
    private CategoryEntity getByCategoryName(String name){
        CategoryEntity categoryEntity = categoryRepository.getByName(name);
        return categoryEntity;
    }


    public List<CategoryResponse> getAllCategory() {
        return null;
    }
}
