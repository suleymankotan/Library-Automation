package com.example.library_Automation.repository;

import com.example.library_Automation.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
    BookEntity getByName(String bookName);
}
