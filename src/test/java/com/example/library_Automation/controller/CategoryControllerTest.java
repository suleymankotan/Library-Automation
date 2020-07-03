package com.example.library_Automation.controller;

import com.example.library_Automation.service.CategoryService;
import com.example.library_Automation.service.WriterService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

public class CategoryControllerTest extends AbstractControllerTest {
    @Mock
    private CategoryService categoryService;

    @BeforeEach
    public void setup() {
        super.setup(new CategoryController(categoryService));
    }
}
