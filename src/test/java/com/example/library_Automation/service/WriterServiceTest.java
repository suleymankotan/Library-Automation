package com.example.library_Automation.service;

import com.example.library_Automation.converter.BookConverter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class WriterServiceTest {
    @InjectMocks
    private WriterService writerService;

    @Spy
    private final BookConverter bookConverter = Mappers.getMapper(BookConverter.class);
}
