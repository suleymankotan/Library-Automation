package com.example.library_Automation.service;

import com.example.library_Automation.entity.BookEntity;
import com.example.library_Automation.exception.ErrorCode;
import com.example.library_Automation.exception.LibraryServiceException;
import com.example.library_Automation.filter.UserThreadLocal;
import com.example.library_Automation.model.request.BookRequest;
import com.example.library_Automation.model.response.BaseResponse;
import com.example.library_Automation.model.response.BookResponse;
import com.example.library_Automation.repository.BookRepository;
import com.example.library_Automation.repository.CategoryRepository;
import com.example.library_Automation.repository.PublisherRepository;
import com.example.library_Automation.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    private final PublisherRepository publisherRepository;
    private final WriterRepository writerRepository;

    public BaseResponse saveBook(BookRequest bookRequest){
        return null;
    }

    public BookResponse getByBookName(String bookName){
        BookEntity bookEntity=getByBook(bookName);
        if (bookEntity == null)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);


        return BookResponse.builder()
                .bookSize(bookEntity.getBookSize())
                .categoryName(bookEntity.getCategory().getName())
                .writerName(bookEntity.getWriter().getName())
                .publicDate(bookEntity.getPublicDate())
                .writerSurname(bookEntity.getWriter().getSurname())
                .name(bookEntity.getName())
                .build();
    }

    public List<BookResponse> getAllBooks(){
        return null;
    }

    public BaseResponse updateBook(BookRequest bookRequest){
        return null;
    }

    private BookEntity getByBook(String bookName){
        BookEntity bookEntity = bookRepository.getByName(bookName);
        return bookEntity;
    }

}
