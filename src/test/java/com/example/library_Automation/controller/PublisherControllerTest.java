package com.example.library_Automation.controller;

import com.example.library_Automation.service.PublisherService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

public class PublisherControllerTest extends AbstractControllerTest {
    @Mock
    private PublisherService publisherService;

    @BeforeEach
    public void setup() {
        super.setup(new PublisherController(publisherService));
    }
}
