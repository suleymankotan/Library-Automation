package com.example.library_Automation.controller;

import com.example.library_Automation.model.response.*;
import com.example.library_Automation.repository.BookRepository;
import com.example.library_Automation.repository.CategoryRepository;
import com.example.library_Automation.repository.PublisherRepository;
import com.example.library_Automation.repository.WriterRepository;
import com.example.library_Automation.service.BookService;
import com.example.library_Automation.service.CategoryService;
import com.example.library_Automation.service.PublisherService;
import com.example.library_Automation.service.WriterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest extends AbstractControllerTest {
    @Mock
    private BookService bookService;




    @BeforeEach
    public void setup() {
        super.setup(new BookController(bookService));
    }

    @Test
    public void shouldSuccessfullyGetAllBook() throws Exception {
        final List<BookResponse> response = Collections.singletonList(BookResponse.builder()
                .name("test").bookSize(100L).category(CategoryResponse.builder().name("test").build())
                .publicDate(LocalDateTime.of(2020, 1, 1, 13, 0))
                .publisher(PublisherResponse.builder().name("test").build())
                .writer(WriterResponse.builder().name("test").surname("test").build()).build());

        when(bookService.getAllBooks()).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/book/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].name", is("test")))
                .andExpect(jsonPath("$.[0].bookSize", is(100)))
                .andExpect(jsonPath("$.[0].category.name", is("test")))
                .andExpect(jsonPath("$.[0].publisher.name", is("test")))
                .andExpect(jsonPath("$.[0].writer.name", is("test")))
                .andExpect(jsonPath("$.[0].writer.surname", is("test")))
                .andExpect(jsonPath("$.[0].publicDate[0]", is(2020)))
                .andExpect(jsonPath("$.[0].publicDate[1]", is(1)))
                .andExpect(jsonPath("$.[0].publicDate[2]", is(1)))
                .andExpect(status().isOk());
        verify(bookService).getAllBooks();
    }

   /* @Test
    public void shouldSuccessfullySaveBook() throws Exception {
        final BaseResponse response = BaseResponse.builder().code(200).message("İşlem Başarılı.").build();
        final BookRequest request = BookRequest.builder().name("test").bookSize(100L)
                .publicDate(LocalDateTime.now()).categoryName("test")
                .publisherName("test").writerName("test").writerSurname("test").build();
      /*  final WriterEntity writerEntity = WriterEntity.builder().id(1L).surname("test").name("test").build();
        final CategoryEntity categoryEntity = CategoryEntity.builder().id(1L).name("test").build();
        final PublisherEntity publisherEntity = PublisherEntity.builder().id(1L).name("test").build();
        when(bookService.saveBook(any(BookRequest.class))).thenReturn(response);
      /*  when(bookRepository.getByName(anyString())).thenReturn(null);

        when(writerService.saveBookWriter(anyString(),anyString())).thenReturn(writerEntity);
        when(categoryService.saveBookCategory(anyString())).thenReturn(categoryEntity);
        when(publisherService.saveBookPublisher(anyString())).thenReturn(publisherEntity);

        when(writerRepository.getByName(anyString())).thenReturn(writerEntity);
        when(categoryRepository.getByName(anyString())).thenReturn(categoryEntity);
        when(publisherRepository.getByName(anyString())).thenReturn(publisherEntity);

        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(objectMapper.writeValueAsString(request)))

                .andExpect(status().isOk());

        verify(bookService).saveBook(any(BookRequest.class));
    }*/

    @Test
    public void shouldSuccessfullyUpdateBook() {

    }

    /*@Test
    public void shouldSuccessfullyDeleteBook() throws Exception {
        final BaseResponse response = BaseResponse.builder().code(200).message("İşlem Başarılı.").build();
        when(bookService.deleteBook(anyString())).thenReturn(response);
        mockMvc.perform(delete("/book", "test")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(bookService).deleteBook(anyString());
    }*/

    @Test
    public void shouldSuccessfullyGetByBookName() {

    }
}
