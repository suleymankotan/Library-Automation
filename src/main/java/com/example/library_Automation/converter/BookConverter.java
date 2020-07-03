package com.example.library_Automation.converter;

import com.example.library_Automation.entity.BookEntity;
import com.example.library_Automation.entity.CategoryEntity;
import com.example.library_Automation.entity.PublisherEntity;
import com.example.library_Automation.entity.WriterEntity;
import com.example.library_Automation.model.response.BookResponse;
import com.example.library_Automation.model.response.CategoryResponse;
import com.example.library_Automation.model.response.PublisherResponse;
import com.example.library_Automation.model.response.WriterResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookConverter {
    BookResponse bookEntityConverterBookResponse(BookEntity bookEntity);
    List<BookResponse> bookListConverterBookListEntity(List<BookEntity> bookEntityList);
    List<CategoryResponse> categoryListConverterBookListEntity(List<CategoryEntity> categoryEntityList);
    List<PublisherResponse> publisherListConverterBookListEntity(List<PublisherEntity> publisherEntityList);
    List<WriterResponse> writerListConverterBookListEntity(List<WriterEntity> writerEntityList);
}
