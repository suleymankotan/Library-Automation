package com.example.library_Automation.converter;

import com.example.library_Automation.entity.BookEntity;
import com.example.library_Automation.model.response.BookResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookConverter {
    BookResponse bookEntityConverterBookResponse(BookEntity bookEntity);
    List<BookResponse> bookListConverterBookListEntity(List<BookEntity> bookEntityList);

}
