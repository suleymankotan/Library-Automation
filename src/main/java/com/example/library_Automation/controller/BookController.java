package com.example.library_Automation.controller;

import com.example.library_Automation.model.response.BookResponse;
import com.example.library_Automation.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/{bookname}")
    public BookResponse getByBookName(@PathVariable("bookname") String bookName){
        return bookService.getByBookName(bookName);
    }
}
