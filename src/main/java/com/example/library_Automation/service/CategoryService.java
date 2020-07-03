package com.example.library_Automation.service;

import com.example.library_Automation.converter.BookConverter;
import com.example.library_Automation.entity.CategoryEntity;
import com.example.library_Automation.exception.ErrorCode;
import com.example.library_Automation.exception.LibraryServiceException;
import com.example.library_Automation.model.request.CategoryRequest;
import com.example.library_Automation.model.request.CategoryUpdateRequest;
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
    private final BookConverter bookConverter;


    public CategoryEntity saveBookCategory(String categoryName){
        CategoryEntity categoryEntity= getByCategoryName(categoryName);
        if (categoryEntity!= null)
            return categoryEntity;
        return categoryRepository.save(CategoryEntity.builder().name(categoryName).build());
    }

    public BaseResponse saveCategory(CategoryRequest request){
        CategoryEntity categoryEntity= getByCategoryName(request.getName());
        if (categoryEntity!= null)
            throw new LibraryServiceException(ErrorCode.GENERAL_EXCEPTION);
        categoryRepository.save(CategoryEntity.builder().name(request.getName()).build());
        return BaseResponse.success();
    }

    public BaseResponse deleteCategory(String categoryName){
        CategoryEntity entity = getByCategoryName(categoryName);
        if (entity == null)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        categoryRepository.delete(entity);
        return  BaseResponse.success();
    }

    public BaseResponse updateCategory(CategoryUpdateRequest request){
        CategoryEntity entity = getByCategoryName(request.getOldCategory());
        if (entity == null)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        if (getByCategoryName(request.getNewCategory())!= null)
            throw new LibraryServiceException(ErrorCode.GENERAL_EXCEPTION);
        entity.setName(request.getNewCategory());
        categoryRepository.save(entity);
        return BaseResponse.success();
    }

    private CategoryEntity getByCategoryName(String name){
        return categoryRepository.getByName(name);
    }

    public List<CategoryResponse> getAllCategory() {
        List<CategoryEntity> entityList = categoryRepository.findAll();
        if (entityList.size()==0)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);

        return bookConverter.categoryListConverterBookListEntity(entityList);
    }
}
