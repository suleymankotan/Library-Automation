package com.example.library_Automation.controller;

import com.example.library_Automation.model.request.BookRequest;
import com.example.library_Automation.model.response.BaseResponse;
import com.example.library_Automation.model.response.BookResponse;
import com.example.library_Automation.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/{bookName}")
    public BookResponse getByBookName(@PathVariable("bookName") String bookName){
        return bookService.getByBookName(bookName);
    }

    @PostMapping
    public BaseResponse saveBook(@RequestBody @Valid BookRequest request){
        return bookService.saveBook(request);
    }
    @PutMapping
    public BaseResponse updateBook(@RequestBody @Valid BookRequest request){
        return bookService.updateBook(request);
    }
    @GetMapping("/all")
    public List<BookResponse> getAllBook(){
        return bookService.getAllBooks();
    }
    @DeleteMapping("/{bookName}")
    public BaseResponse deleteBook(@PathVariable("bookName") String bookName){
        return bookService.deleteBook(bookName);
    }
}
