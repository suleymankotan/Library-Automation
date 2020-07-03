package com.example.library_Automation.service;

import com.example.library_Automation.converter.BookConverter;
import com.example.library_Automation.entity.BookEntity;
import com.example.library_Automation.exception.ErrorCode;
import com.example.library_Automation.exception.LibraryServiceException;
import com.example.library_Automation.model.request.BookRequest;
import com.example.library_Automation.model.response.BaseResponse;
import com.example.library_Automation.model.response.BookResponse;
import com.example.library_Automation.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;
    private final BookConverter bookConverter;
    private final PublisherService publisherService;
    private final WriterService writerService;




    public BaseResponse saveBook(BookRequest bookRequest) {
        BookEntity bookEntity = getByBook(bookRequest.getName());;
        if (bookEntity != null)
            throw new LibraryServiceException(ErrorCode.GENERAL_EXCEPTION);
         bookRepository.save(BookEntity.builder()
                .bookSize(bookRequest.getBookSize())
                .createdDate(LocalDateTime.now())
                .category(categoryService.saveBookCategory(bookRequest.getCategoryName()))
                .name(bookRequest.getName())
                .publicDate(bookRequest.getPublicDate())
                .publisher(publisherService.saveBookPublisher(bookRequest.getPublisherName()))
                .writer(writerService.saveBookWriter(bookRequest.getWriterName(), bookRequest.getWriterSurname()))
                .build());
        return BaseResponse.success();
    }


    public BookResponse getByBookName(String bookName) {
        BookEntity bookEntity = getByBook(bookName);
        if (bookEntity == null)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        return bookConverter.bookEntityConverterBookResponse(bookEntity);
    }

    public List<BookResponse> getAllBooks() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        if (bookEntityList.size() == 0)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        return bookConverter.bookListConverterBookListEntity(bookEntityList);
    }

    public BaseResponse updateBook(BookRequest bookRequest) {
        BookEntity bookEntity = bookRepository.getByName(bookRequest.getName());
        if (bookEntity == null)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        bookRepository.save(BookEntity.builder()
                .id(bookEntity.getId())
                .bookSize(bookRequest.getBookSize())
                .category(categoryService.saveBookCategory(bookRequest.getCategoryName()))
                .name(bookRequest.getName())
                .publicDate(bookRequest.getPublicDate())
                .publisher(publisherService.saveBookPublisher(bookRequest.getPublisherName()))
                .writer(writerService.saveBookWriter(bookRequest.getWriterName(),bookRequest.getWriterSurname()))
                .updateDate(LocalDateTime.now())
                .build());
        return BaseResponse.success();
    }

    private BookEntity getByBook(String bookName) {
        return bookRepository.getByName(bookName);
    }

    public BaseResponse deleteBook(String name) {
        BookEntity bookEntity= getByBook(name);
        if (bookEntity == null)
            throw new LibraryServiceException(ErrorCode.NO_RECORDS_FOUND);
        bookRepository.delete(bookEntity);
        return BaseResponse.success();
    }
}
