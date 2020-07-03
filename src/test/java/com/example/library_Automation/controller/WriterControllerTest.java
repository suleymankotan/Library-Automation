package com.example.library_Automation.controller;

import com.example.library_Automation.service.WriterService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

public class WriterControllerTest extends AbstractControllerTest {
    @Mock
    private WriterService writerService;

    @BeforeEach
    public void setup() {
        super.setup(new WriterController(writerService));
    }

}
